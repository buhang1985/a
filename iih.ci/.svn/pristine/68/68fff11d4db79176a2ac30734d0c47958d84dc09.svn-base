package iih.ci.ord.s.external.gvchina.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.i.external.gvchina.meta.GvEnDiagRstInfo;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者就诊诊断信息业务处理逻辑
 * @author wangqingzhu
 *
 */
public class GetPatEnDiagInfos extends BaseGetPatInfo{

	public GvEnDiagRstInfo[] exec(String code_en,String code_dept) throws BizException{
		// 有效性判断
		if (CiOrdUtils.isEmpty(code_en) || CiOrdUtils.isEmpty(code_dept)){
			throw new BizException("就诊编码或者科室编码不能为空");
		}
		// 获取患者就诊信息
		OpBasicDTO opBasicInfo = ServiceFinder.find(IEnOutQryService.class).getOpBasicInfoByEntCode(code_en);
		if( null == opBasicInfo){
			throw new BizException(String.format("不存在患者就诊信息（code_en:%s",code_en));
		}
		//保存就诊的当前诊断
		EntDiDO[] szEntDiDO = ServiceFinder.find(IEntdiRService.class).findByAttrValString(EntDiDO.ID_ENT, opBasicInfo.getId_ent());
		if (null == szEntDiDO || szEntDiDO.length == 0){
			throw new BizException(String.format("不存在就诊诊断信息（code_en:%s",code_en));
		}
		
		// 获取科室ID
		String id_dep = getDeptIdByCode(code_dept);
		if( null == id_dep || id_dep.length() == 0){
			throw new BizException(String.format("不存在科室信息（code_dept:%s",code_dept));
		}
		
		// 组装返回值信息
		List<GvEnDiagRstInfo> infoList = new ArrayList<GvEnDiagRstInfo>();
		for (EntDiDO di : szEntDiDO){
			// 按照科室ID过滤数据
			if(di.getId_dep().equals(id_dep)){
				GvEnDiagRstInfo info = new GvEnDiagRstInfo();
				info.setId_key(opBasicInfo.getCode_pat()+opBasicInfo.getTimes_op());
				info.setPatCode(opBasicInfo.getCode_pat());
				info.setEnTimes(opBasicInfo.getTimes_op());
				info.setDoctorCode(di.getId_emp_phy());
				info.setCode(di.getCode_didef_dis());
				info.setName(di.getName_didef_dis());
				info.setDiagTime(di.getDt_diag().toStdString());
				infoList.add(info);
			}
		}
		
		
		return infoList.size() == 0? null:infoList.toArray(new GvEnDiagRstInfo[infoList.size()]);
	}
}
