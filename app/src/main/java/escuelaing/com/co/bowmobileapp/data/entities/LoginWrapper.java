package escuelaing.com.co.bowmobileapp.data.entities;

public class LoginWrapper
{

    private final String email;

    private final String password;

    public LoginWrapper( String email, String password )
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
