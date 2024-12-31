package iih.bd.srv.emrtpl.s;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.bd.srv.emrtpl.bp.MrtplQueryBP;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IMrtplForPreService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 模板扩展服务
 * @author yankan
 *
 */
@Service(serviceInterfaces={IMrtplForPreService.class}, binding=Binding.JSONRPC)
public class MrtplForPreServiceImpl implements IMrtplForPreService {
	private MrtplQueryBP queryBP = new MrtplQueryBP();
	public MrtplForPreServiceImpl(){
		
	}
	/**
	 * 获取预检模板
	 * @param depId 部门id
	 * @param mrtpCode 模板类型编码
	 * @return
	 * @throws BizException
	 */
	public EmrTplDO[] getPreMrtpl(String depId,String mrtpCode) throws BizException{
		return this.queryBP.getPreMrtpl(depId, mrtpCode);
	}
	/**
	 * 获取体征采集项目列表
	 * @param mrtplId 模板id
	 * @return
	 * @throws BizException
	 */
	public PhySignDTO[] getPhySignDTOList(String mrtplId) throws BizException{
		return this.queryBP.getPhySignDTOList(mrtplId);
	}
	/**
	 * 获取体征采集项目列表
	 * @param depId 部门id
	 * @param mrtpCode 模板类型编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public PhySignDTO[] getPrePhySignDTOList(String depId, String mrtpCode)
			throws BizException {
		String mrtplId = null;
		EmrTplDO[] dos = this.queryBP.getPreMrtpl(depId, mrtpCode);
		if(ArrayUtil.isEmpty(dos))
			return null;
		if(dos.length>1){
			boolean first = true;
			//默认取当前科室的，否则取第一个
			for(EmrTplDO tplDO : dos){
				if(first){
					mrtplId = tplDO.getId_mrtpl();
					first = false;
				}else{
					if(!StringUtil.isEmptyWithTrim(depId) && depId.equals(tplDO.getId_dept())){
						mrtplId = tplDO.getId_mrtpl();
						break;
					}
				}				
			}
		}else if(dos.length==1){
			mrtplId = dos[0].getId_mrtpl();
		}else{
			return null;
		}
		
		
		return this.queryBP.getPhySignDTOList(mrtplId);
	}
	

}
