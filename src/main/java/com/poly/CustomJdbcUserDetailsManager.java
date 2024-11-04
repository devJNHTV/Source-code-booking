package com.poly;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;

public class CustomJdbcUserDetailsManager extends JdbcUserDetailsManager {
    
    public CustomJdbcUserDetailsManager(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    protected void initDao() {
        setUsersByUsernameQuery("select username, password, enabled from Accounts where username = ?");
        setAuthoritiesByUsernameQuery(
                "select u.username, r.name as authority " +
                "from Authorities a " +
                "join Accounts u on a.Username = u.Username " +
                "join Roles r on a.RoleID = r.Id " +
                "where u.Username = ?"
            );
    }

    @Override
    public void createUser(UserDetails user) {
        // Implement custom logic if needed, or call super to use default implementation
        super.createUser(user);
    }
}