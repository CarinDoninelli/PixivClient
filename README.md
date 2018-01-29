# PixivClient

## Example

```java
public class Example {
    public static void main(String[] args) {
        Credentials credentials = new PasswordCredentials("email", "password");
        PixivClientFactory pixivClientFactory = new PixivClientFactory();
        PixivClient pixivClient = pixivClientFactory.createPixivClient(credentials); 
        
        User user = pixivClient.getUserInfo(146324).join();
        System.out.println(user.getAccount());
    }
}
```
