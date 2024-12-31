package iih.ci.mr.s.bp.createmr;

import java.util.Random;

public class AutoCreateMrRandomNumBp {

	// 产生n位随机数
	public String randomString(int codeCount) {
		String result = new String();
        long num2 = System.currentTimeMillis();
        Random random = new Random((((num2) & 0xffffffffL)) | ((int) (num2 >> 1)));
        for (int i = 0; i < codeCount; i++)
        {
            int num = random.nextInt();
            result = result + ((char) (0x30 + (((0xFFFF&num)%10))));
        }
        return result;
	 }
}
