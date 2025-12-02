package de.seuhd.campuscoffee.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import de.seuhd.campuscoffee.domain.ports.UserService;
import de.seuhd.campuscoffee.api.mapper.UserDtoMapper;
import de.seuhd.campuscoffee.api.dtos.UserDto;
import de.seuhd.campuscoffee.domain.model.User;

ipmort java.util.List;


@Tag(name = "Users", description = "Operations related to user management.")
@Controller
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    //TODO: Implement user controller

    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(
            userService.getAllUsers().stream()
                .map(userDtoMapper::fromDomain)
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(
            userDtoMapper.fromDomain(
                userService.getUserById(id)
            )
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<List<UserDto>> filter(
        @RequestParam("loginName") String loginName) {
        return ResponseEntity.ok(
            userDtoMapper.fromDomain(
                userService.getUserByLoginName(loginName)
            )
        );
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        User createdUser = upsertUser(userDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.id())
                .toUri();
                .body(createdUser);
        );
    }    

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
        @PathVariable Long id,
        @RequestBody @Valid UserDto userDto) {
            if (!id.equals(userDto.id())) {
                throw new IllegalArgumentException("User ID in path and body do not match.");
            }
            return ResponseEntity.ok(
                upsertUser(userDto)
            );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    private User upsertUser(UserDto userDto) {
        return userDtoMapper.fromDomain(
            userService.upsertUser(
                userDtoMapper.toDomain(userDto)
            )
        );
    }
}    