package iih.pi.reg.pat.s.impt;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaCudService;
import xap.sys.bdfw.bbd.i.IAdminareaRService;

/**
 * 处理区县数据层级关系类
 * 由于没有sys权限，固将逻辑写到pi里
 * @author ly
 *
 */
public class HandleAdminAreaDataBP {

	/**
	 * 重新设置id_parent字段
	 * @throws BizException
	 */
	public void exec() throws BizException{
	
		IAdminareaRService rService = ServiceFinder.find(IAdminareaRService.class);
		IAdminareaCudService cudService = ServiceFinder.find(IAdminareaCudService.class);
		
		AdminAreaDO[] datas = rService.find("a0.ds = 0", "a0.code", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(datas))
			return;
		
		String firstParentId = "";//第一层级id
		String sencondParentId = "";//第二层级id
		//设置idparent
		for (AdminAreaDO data : datas) {
			data.setStatus(DOStatus.UPDATED);
			
			if(this.checkIfFirstLevel(data.getCode())){
				firstParentId = data.getId_adminarea();
				sencondParentId = "";
				continue;
			}
			
			if(this.checkIfSecondLevel(data.getCode())){
				data.setId_parent(firstParentId);
				sencondParentId = data.getId_adminarea();
				continue;
			}
			
			if("".equals(sencondParentId)){
				data.setId_parent(firstParentId);
			}else{
				data.setId_parent(sencondParentId);
			}
		}
		
		cudService.update(datas);
	}
	
	/**
	 * 判断是否第一层级
	 * @param code
	 * @return
	 */
	private boolean checkIfFirstLevel(String code){
		return "0000".equals(code.substring(2, code.length()));
		
	}
	
	/**
	 * 判断是都第二层级
	 * @param code
	 * @return
	 */
	private boolean checkIfSecondLevel(String code){
		return "00".equals(code.substring(4, code.length()));
	}
}
