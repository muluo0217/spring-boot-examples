package indi.zhaosheng.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author muluo
 * @description
 * @date 2020/7/19 22:41
 */
public class JwtUtil {
    private JwtUtil() {
    }

    private static final long EXPIRE_TIME = 60 * 1000;
    private static final String TOKEN_SECRET = "token123token123token123token123token123token123token123token123token123token123token123";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(TOKEN_SECRET));


    public static String createToken(String userName) {

        return Jwts.builder()
                .setSubject(userName)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .compact();
    }

    public static void verifyToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
        System.out.println(claimsJws.getBody().getSubject());
    }

    public static void main(String[] args) {
        String token = createToken("123");
        System.out.println(token);
        verifyToken(token);
        verifyToken(token+1);
    }
}
