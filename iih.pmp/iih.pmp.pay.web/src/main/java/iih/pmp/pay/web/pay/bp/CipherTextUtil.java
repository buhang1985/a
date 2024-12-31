package iih.pmp.pay.web.pay.bp;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import com.sun.crypto.provider.SunJCE;
import sun.misc.BASE64Decoder;

public class CipherTextUtil {
	
//	private static final String serectKey = "your API Serect key";

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";
    /**
     * 生成key
     */
    private static SecretKeySpec key = new SecretKeySpec(WXPayNotifyAppUtils.getMd5Encode().toLowerCase().getBytes(), ALGORITHM);

    static {
        try {
            Security.addProvider(new BouncyCastleProvider());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * AES解密
     */
    public static String decryptData(byte[] b) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(b));
    }

  
    public static void main(String[] args) throws Exception {

        String A = "XjNzqEfAUM1mlqHrZAI0ET+UdSmIcCWKjvnMgINFm93ELqgM+Wso4z3EoWGRdYD7lNKLxPwxKFb1azATWbXF/BA5smGJ8Ib7VRY125x4Sv7EXTiZojPtxLVsgIlF9bq3CRa/f4ba4UcJPkXt2e5rp7FP7jPbGnh7TJo3VymlcJC6iNTSw1ilQpyCQHiimRxy4QXHPysOcKNtlhWf4Yzjoqj3j1kgYAuM+VMuEphnNMGMIs4GRDMhqsHGAhBd/4KwTgdVG0r1dREzdrrfqpXKyQ5yeslBruHWDMBThI8KmVspwHtTuOVztM2KEiozo5+ytXq++gQZ9pr0i/QYICwBfCUhRVA2SAP3H01sLppbED/fQF7DnydUyyrOYizwn/7QVhoYxt0lePfAojsfSowkhTcyqvOOCvH84uPFuXP88R4WHyiR3GiF6mCjhpvRkdNddTiLi4/vPpQfIA0IU3SD2qzKmJty1oPSWhHy0ol3rOtqT01aayVkez+rAiDQ5R742uUL3HGIqszW2JuAyYA04DZlNN4H0tq/F5B6/PAFOQwoo4M+at/7arVVtXVr92PKvBgBvbkLkGWVHMUR0w8/BdU0kVEdwFB61E52rbYbPFZL1+JmJo5yQ5TndKpVVVTLewDznZAn/cSx47TOQJXyCO6IUYJYZmuC+28+LrP1KUUrmjg3Y6J4cq2QnsYSr4lKcPnjYn+sBgyJnG+qhtQX/alviWVm0+z5NZ/H6QBQa0+AX5xBECQfz5/IUXodR3i1LcaRvbkELnrZWgXTRLEeNFnq2lHHm21Y88iCu7jN9Rcd7iBIcde5PEPBCjJQQ0tlOdvld71JdyklsNj9b5zckj1fUj9xf49JNXI1djQSla93zNzmgy7n/RczzsbgZExmYJeECrOwONzxvIzPF9d3ekslPuRXdUpygImvE+yr664U/oKyZYWYf5U+D1nWwShJlqMO5eUx/uYdIu/0hMXUz2fv+BOJK+h0y//G45w/sFSyguv/Bd30aPlP3kFcrg5gbORcsn6dd6Zjh6TsGbeBbA==";
     
        byte[] k=new BASE64Decoder().decodeBuffer(A);
      
        String B = CipherTextUtil.decryptData(k);
        System.out.println(B);
     

    }
    
    public static byte[] Aes256Encode(String str, byte[] key){  
        byte[] result = null;  
        try{  
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");  
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key  
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);  
            result = cipher.doFinal(str.getBytes("UTF-8"));  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return result;  
    }  

}
