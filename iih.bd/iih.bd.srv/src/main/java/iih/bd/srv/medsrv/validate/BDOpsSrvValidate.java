package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/// <summary>
/// <para>描    述 :  手术服务基础数据检查                   			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  BDOpsSrvValidate					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  qzwang         				</para> 
/// <para>修 改 人 :  qzwang         				</para> 
/// <para>创建时间 :  10/19/2016 9:02:47 PM             </para>
/// <para>更新时间 :  10/19/2016 9:02:47 PM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
/// </summary>
public class BDOpsSrvValidate extends BDSetSrvValidate {

	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(),medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList))
			info = errorList.get(errorList.size() - 1);
		MedSrvOpDO[] szMedSrvOpDO = ServiceFinder.find(IMedSrvOpDORService.class).find(String.format(" id_srv = '%s'", medsrv.getId_srv()), "", FBoolean.FALSE);
		if (szMedSrvOpDO == null || szMedSrvOpDO.length<=0){
			info.getDescList().add("手术属性表为空");
		}
		else{
			// CheckOpsInfo(szMedSrvOpDO[0],info.getDescList()); // PO 要求暂时不检查
		}
		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}
	
	protected void CheckOpsInfo(MedSrvOpDO s, List<String> e) {
		
		if (StringUtil.isEmpty(s.getId_opclass()))
        {
            e.add("手术级别为空");
        }
		if (StringUtil.isEmpty(s.getSd_opclass()))
        {
            e.add("手术级别编码为空");
        }
		if (StringUtil.isEmpty(s.getId_didef()))
        {
            e.add("关联诊断为空");
        }
//		if (StringUtil.isEmpty(s.getId_diag_op()))
//        {
//            e.add("手术为空");
//        }
	}

	

}
