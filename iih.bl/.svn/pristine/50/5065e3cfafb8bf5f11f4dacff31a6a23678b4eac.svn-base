package iih.bl.comm.util;

import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 费用域校验工具类
 * @author ly 2018/05/24
 *
 */
public class BlValidateUtil {

	/**
	 * 后台任务上下文值必须校验
	 * @param context
	 * @throws BizException
	 */
	public static void validateContextForTask(Context context) throws BizException{
		
		if(context == null)
			return;
		
		if(StringUtil.isEmpty(context.getGroupId())){
			throw new BizException("上下文集团id为空");
		}
		
		if(StringUtil.isEmpty(context.getOrgId())){
			throw new BizException("上下文组织id为空");
		}
	}
	
	/**
	 * 判断是否婴儿
	 * @param entId
	 * @throws BizException
	 */
	public static FBoolean isEntBaby(String entId) throws BizException{
		
		IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
		EnMomBabyInfoDTO[] dtos = enService.getMomBabyInfos(new String[]{entId});
		
		if(ArrayUtil.isEmpty(dtos))
			return FBoolean.FALSE;
		
		for (EnMomBabyInfoDTO dto : dtos) {
			if(entId.equals(dto.getId_ent_bb())){
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}
	
	/**
	 * 判断是否母亲
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static FBoolean isEntMom(String entId) throws BizException{
		
		IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
		EnMomBabyInfoDTO[] dtos = enService.getMomBabyInfos(new String[]{entId});
		
		if(ArrayUtil.isEmpty(dtos))
			return FBoolean.FALSE;
		
		for (EnMomBabyInfoDTO dto : dtos) {
			if(entId.equals(dto.getId_ent_mom())){
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}
}
