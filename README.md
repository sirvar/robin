![logo](/assets/logo.png?raw=true)
## 🚀 Android login, made simple Edit

Almost every app has a login and signup, so why do we re-write code everytime? Let robin handle that for you.

![login](/assets/login.png?raw=true) ![signup](/assets/signup.png?raw=true)

# Usage
Add this to your **build.gradle**

Create a new activity to handle login and signup requests that extends **RobinActivity**
```java
public class MainActivity extends RobinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DO NOT call setContentView();	

        // Set title for each screen
        setLoginTitle("Sign in to Robin");
        setSignupTitle("Welcome to Robin");
        setForgotPasswordTitle("Forgot Password");		

        // Set logo for screens
        setImage(getResources().getDrawable(R.mipmap.ic_launcher));		

        // Use custom font across all views
        setFont(Typeface.createFromAsset(getAssets(), "Montserrat-Medium.ttf"));		

        // Choose theme (default is LIGHT)
        setTheme(Theme.LIGHT);
    }
}
```

## Themes
| Theme Name | Usage |
| ---------- | -----:|
| Light |  Theme.LIGHT |
| Dark | Theme.DARK &#42; |
| Flat | Theme.FLAT &#42; |
| Gradient | Theme.GRADIENT &#42; |
| Blur | Theme.BLUR &#42; |

&#42; Coming soon
