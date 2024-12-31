package iih.ci.ord.s;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiDeptMainService;
import iih.ci.ord.i.meta.DeptQryParam;
import iih.ci.ord.i.meta.DeptQryRstInfo;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;

/**
 * 临床科室信息查询接口
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiDeptMainService.class }, binding = Binding.JSONRPC)
public class CiDeptMainServiceImpl implements ICiDeptMainService {

	@Override
	public DeptQryRstInfo[] QueryDeptInfos(CiEnContextDTO ctx, DeptQryParam[] szParams) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public DeptQryRstInfo QueryDeptInfo(CiEnContextDTO ctx, DeptQryParam param) throws BizException {
		// TODO Auto-generated method stub
		DeptQryRstInfo rstInfo = new DeptQryRstInfo();
		OrWfDeptInfoDTO deptInfo = null;
		if(StringUtils.isEmpty(param.getId_dosage())){
			deptInfo = DeptInfoUtils.GetOrWfDeptInfo(ctx, param.getId_srv(), param.getId_mm(), param.getId_route(),  param.getId_dep_main(), 
					param.getFg_long(),ctx.getFg_pres_outp(),param.getDt_effe());
		}
		else{
			deptInfo = DeptInfoUtils.GetOrWfDeptInfo(ctx, param.getId_srv(),param.getId_mm(), param.getId_route(),param.getId_dep_main(),
					param.getFg_long(),ctx.getFg_pres_outp(),  param.getDt_effe());
		}
		if(null != deptInfo){
			rstInfo.setDocument(new FArrayList());
			rstInfo.getDocument().add(deptInfo);
		}
		return rstInfo;
	}

}
