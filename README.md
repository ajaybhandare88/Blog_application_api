# Blog_application_api
Go to api documentation page 
http://blogapp-env.eba-cd4qdtuw.us-east-1.elasticbeanstalk.com/swagger-ui/index.html
You can access without authentication POST_CONTROLLER for the create new user after you can access all url using created user USERNAME and PASSWORD  
# _________________________________________User Services______________________________________________________________________________
# Create new user {POST}
Endpoint: /new/user/?roleId={roleId}    ROLE_ADMIN id=1 and ROLE_ADMIN id=2
Description: Registers a new user in the system.
Actions: Requires name, email, password, and about .
# Fetch user {GET}
Endpoint: /api/user/{userId}    
Description: Fetch a user using user id.
Actions: User id.
# Fetch all user defult pagination {GET}
Endpoint: Requires /api/user/page   
Description: Fetch all user with defult pagination pageNumber=0 and pageSize=4.
# Fetch all user custom pagination {GET}
Endpoint: Requires /api/user/page?pageNumber={PageNumber}&pageSize={PageSize}
Description: Fetch all user with defult pagination pageNumber=0 and pageSize=4.
# Update user {PUT}
Endpoint: Requires /api/user/{userId}
Description: Update user.
# Delete user {DELETE}
Endpoint: Requires /api/user/{userId}
Description: Delete user.
# Assign new role {POST}
Endpoint: Requires /api/user/addNewRole?userId={userId}&roleId{roleId}
Description: Assign new role.
# _________________________________________Post Services______________________________________________________________________________
# Get post using post id {GET}
Endpoint: Requires /api/post/{id}
Description: Fetch post using id.
# Update post using post id {PUT}
Endpoint: Requires /api/post/{id}
Description: Update post using id.
# Delete post using post id {DELETE}
Endpoint: Requires /api/post/{id}
Description: Delete post using id.
# Create post using user id and category id {POST}
Endpoint: Requires /api/post/{userId}/{categoryId}
Description: Create post.
# Get post using user id and category id {GET}
Endpoint: Requires /api/post/user/{userId}/category/{categoryId}
Description: Get post using user id and category id.
# Get post using user id {GET}
Endpoint: Requires /api/post/user/{userId}/post
Description: Get post using user.
# Get post using category id {GET}
Endpoint: Requires /api/post/category/{categoryId}
Description: Get post using category id.
# Search post {GET}
Endpoint: Requires /api/post/search/{String}
Description: Get post using search functionality.
# Fetch all post defult pagination {GET}
Endpoint: Requires /api/post/page   
Description: Fetch all post with defult pagination pageNumber=0 and pageSize=4.
# Fetch all post custom pagination {GET}
Endpoint: Requires /api/post/page?pageNumber={PageNumber}&pageSize={PageSize}
Description: Fetch all post with defult pagination pageNumber=0 and pageSize=4.
# _________________________________________Category Services______________________________________________________________________________
# Get category using id {GET}
Endpoint: Requires /api/category/{id}
Description: Fetch category using id.
# Update category using id {POST}
Endpoint: Requires /api/category/{id}
Description: Update category.
# Delete category using id {DELETE}
Endpoint: Requires /api/category/{id}
Description: Delete category.
# Create category {POST}
Endpoint: Requires /api/category/
Description: Create category.
# Fetch all category {GET}
Endpoint: Requires /api/category/
Description: Fetch list of category.
# _________________________________________Comment Services______________________________________________________________________________
# Comment on post {POST}
Endpoint: Requires /api/comment/user/{userId}/post/{postId}/comment
Description: Create comment.
# Delete comment using id {DELETE}
Endpoint: Requires /api/comment/{id}
*Description: Delete comment*.
