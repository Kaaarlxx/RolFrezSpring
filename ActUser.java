package projekt.projekt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import projekt.projekt.security.MyUserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class ActUser {

    public static Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails u;
        u = (MyUserDetails) authentication.getPrincipal();
        Long userid = u.getId();
        return userid;
    }

    public static String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails u;
        u = (MyUserDetails) authentication.getPrincipal();
        String  username = u.getUsername();
        return username;
    }

    public static String getRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails u;
        u = (MyUserDetails) authentication.getPrincipal();
        String role = u.getRole();
        return role;

    }

}
