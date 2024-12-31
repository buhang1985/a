package iih.ei.std.s.v1.bp.common.en;



import iih.ei.std.d.v1.utils.EiValidator;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.enres.i.IEnextCudService;
import iih.en.pv.enres.i.IEnextRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * EN_ENT_EXT表EP 应用帮助类
 * @author li.wm
 *
 */
public class EnExtEP {

	/**
	 * 获取就诊扩展记录
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] getByEntIds(String[] entIds)throws BizException{
		if(EiValidator.isEmpty(entIds))
			return null;
		return getRServ().findByAttrValStrings(EnExtDO.ID_ENT, entIds);
	}
	/**
	 * 保存
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] save(EnExtDO[] dos) throws BizException{
		return getCudServ().save(dos);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnextRService getRServ(){
		return ServiceFinder.find(IEnextRService.class);
	}
	
	/**
	 * 获取Cud服务
	 * 
	 * @return
	 */
	public IEnextCudService getCudServ(){
		return ServiceFinder.find(IEnextCudService.class);
	}
	
}
