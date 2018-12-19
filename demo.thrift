namespace java com.demo.service

struct User {
        1:i32 id
        2:string name
        3:i32 age
}

service UserService {

        User getUserById(1:i32 id)
}
