package domain;

import javax.persistence.*;

@Entity
@Table(name = "users_groups")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 50)
    private String title;

    /*@OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    *//*@JoinColumn(name = "user_group_id", nullable = false)*//*
    private Set<User> users;*/

    public UserGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*@OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)*//*
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
