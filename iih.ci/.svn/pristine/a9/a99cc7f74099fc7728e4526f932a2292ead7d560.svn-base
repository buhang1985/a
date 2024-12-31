package iih.ci.sdk.quan;

import org.apache.tuscany.sca.interfacedef.InvalidOperationException;

import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public class QuanMeduCalcUtil {

	/**
	 * 计算药品单次数量
	 * 当前选择的包装单位与医学单位相等时，返回医学单位剂量，否则返回基本包装单位剂量
	 * @param Id_unit_medu 医学单位
	 * @param Factor_mb 当前剂量单位转换系数
	 * @param Quan_medu_cur 当前剂量
	 * @param Id_unit_base 当前剂量单位
	 * @return
	 * @throws BizException 
	 * @throws InvalidOperationException
	 */
	@SuppressWarnings("unused")
	public static String CalcDrugSingleQuantity(String Id_unit_medu, FDouble Factor_mb, 
			FDouble Quan_medu_cur, String Id_unit_medu_cur) throws BizException  
    {
       
        if (Quan_medu_cur == null || ObjectUtils.isEmpty(Id_unit_medu_cur)) {
            return null;
        }
        
        // 当前选择的包装单位与医学单位相等时，返回医学单位剂量，否则返回基本包装单位剂量
        // 判断传入当前剂量单位是否为医学单位，如果为医学单位转换系数返回1
        if (Id_unit_medu_cur.equals(Id_unit_medu)) {
            return Quan_medu_cur.multiply(Factor_mb).toString();
        }
        else 
        {
            if(Factor_mb == null)
            {
               throw new BizException("医基转化系数不能为空 ！", null);
            }
            if(Quan_medu_cur == null)
            {
                return "0";
            }
            if(CanDivisible(Quan_medu_cur.doubleValue(), Factor_mb.doubleValue()))
            {
                return Quan_medu_cur.div(Factor_mb).toString();
            }
            else
            {
               return Quan_medu_cur.div(Factor_mb,2).toString();
            }
            
        }
    }
   
	/**
	 * 判断是否能够整除
	 * @param numerator
	 * @param denominator
	 * @return
	 * @throws BizException
	 */
    private static boolean CanDivisible(double numerator, double denominator) throws BizException  
    {
        int accuracy = 100000;// 小数点后6位
        if ( denominator == 0)
        {
            throw new BizException("医基转化系数不能为 0！", null);
        }
        return numerator * accuracy % denominator * accuracy == 0;
    }
}

