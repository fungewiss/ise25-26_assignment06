package de.seuhd.campuscoffee.tests.system;

import de.seuhd.campuscoffee.api.dtos.UserDto;
import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Objects;

import static de.seuhd.campuscoffee.tests.SystemTestUtils.Requests.userRequests;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersSystemTests extends AbstractSysTest {

    //TODO: Uncomment once user endpoint is implemented

    // does not compile

//    @Test
//    void createUser() {
//        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
//        User createdUser = userDtoMapper.toDomain(userRequests.create(List.of(userDtoMapper.fromDomain(userToCreate))).getFirst());

//        assertEqualsIgnoringIdAndTimestamps(createdUser, userToCreate);
//    }

//     //TODO: Add at least two additional tests for user operations

//     @Test
//     void getAllCreatedUsers() {
//         List<User> createdUserList = TestFixtures.createUsers(userService);
//         List<User> retrievedUsers = userRequests.retrieveAll()
//             .stream()
//             .map(userDtoMapper::toDomain)
//             .toList();
//         assertEqualsIgnoringIdAndTimestamps(retrievedUsers, createdUserList);
//     }    

//     @Test
//     void getUserById() {
//         List<User> createdUserList = TestFixtures.createUsers(userService);
//         User createdUser = createdUserList.getFirst();
//         User retrievedUser = userDtoMapper.toDomain(
//                 userRequests.retrieveById(createdUser.id())
//         );
//         assertEqualsIgnoringIdAndTimestamps(retrievedUser, createdUser);
//     }
}