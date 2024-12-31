package iih.en.pv.s.listener.ip.mp;

import iih.en.comm.ep.EnExtEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.utils.params.EnParamsUtil;
import iih.mp.nr.foreign.d.ForEnTemDataDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 监听Mp生命体征设置en_ent_ext身高
 * 
 * @author 
 *
 */
public class EnSetExtHeightMpListener extends EnVitalSignsMpAbstractListener {
	/**
	 * 过滤出身高相关体征项
	 * 
	 */
	@Override
	public ForEnTemDataDTO[] filter(ForEnTemDataDTO[] datas)
			throws BizException {
		//身高cm服务
		String srvIdHeight = EnParamsUtil.MPNR0113();
		List<ForEnTemDataDTO> list = new ArrayList<ForEnTemDataDTO>();
		for(ForEnTemDataDTO data : datas){
			if(EnValidator.isEmpty(data.getId_srv())
					|| EnValidator.isEmpty(data.getId_ent()))
				continue;
			if(data.getId_srv().equals(srvIdHeight)){
				list.add(data);
				continue;
			}
		}
		return list.isEmpty() ? null : list.toArray(new ForEnTemDataDTO[0]);
	}
	/**
	 * 设置en_ent_ext身高
	 * 
	 */
	@Override
	public void doYourAction(ForEnTemDataDTO[] datas) throws BizException {
		//身高cm服务
		String srvIdHeight = EnParamsUtil.MPNR0113();
		//<K,V>-<Id_ent, 身高值>
		Map<String, Object> map = new HashMap<String, Object>();
		for(ForEnTemDataDTO data : datas){
			if(FBoolean.TRUE.equals(data.getFg_del())){
				map.put(data.getId_ent(), null);
				continue;
			}
			if(data.getId_srv().equals(srvIdHeight)
					&& data.getValue() != null){
				map.put(data.getId_ent(), data.getValue());
				continue;
			}
		}
		if(map.isEmpty())
			return;
		new EnExtEP().updateAttrVals(map, EnExtDO.HEIGHT);
	}
}
