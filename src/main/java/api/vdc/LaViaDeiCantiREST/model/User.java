package api.vdc.LaViaDeiCantiREST.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class User
 */
@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {

   private final static String serialVersionUID = "4L";
   public final static String USERTYPE_STUDENTE = "STUDENTE";
   public final static String USERTYPE_MAESTRO = "MAESTRO";
   public final static String USERSTATUS_ONLINE = "ONLINE";
   public final static String USERSTATUS_OFFLINE = "OFFLINE";

    @Id
    @Column(name = "username")
    private String username  = "";

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "user_type")
    private String user_type;

    @Column(name = "salt")
    private byte[] salt;

    @Column(name = "hash")
    private byte[] hash;

    @Column(name = "status")
    private String userStatus;

    @Transient
    private String password;
}
