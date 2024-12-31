package iih.ci.ord.s.external.provide.bp.bl;

import com.mysql.jdbc.StringUtils;

import iih.en.pv.entdiprove.d.EntDiProveDO;
import iih.en.pv.entdiprove.d.desc.EntDiProveDODesc;
import iih.en.pv.entdiprove.i.IEntdiproveRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetEntDiProveDOsBP {
	public EntDiProveDO[] exec(String id_ent)throws BizException{
		// 入参校验
		if(StringUtils.isNullOrEmpty(id_ent))return null;
		
		// 参数拼接
		IEntdiproveRService service=(IEntdiproveRService)ServiceFinder.find(IEntdiproveRService.class);
		String whereStr=EntDiProveDODesc.TABLE_ALIAS_NAME+".id_ent='"+id_ent+"'";
		
		// 查询诊断证明
		EntDiProveDO[] entDiProveDOs=service.find(whereStr, "", FBoolean.FALSE);

		return entDiProveDOs;
	}
}
