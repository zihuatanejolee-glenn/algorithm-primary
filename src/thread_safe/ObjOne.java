package thread_safe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ObjOne {
    private String name;
    private Integer age;
    private List<String> friends;

    public ObjOne(String name, Integer age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "ObjOne{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends.toArray()) +
                '}';
    }
}
