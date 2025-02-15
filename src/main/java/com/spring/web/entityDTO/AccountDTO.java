package com.spring.web.entityDTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
 
    private List<String> roles;
    private Date createdAccountTime;
}
