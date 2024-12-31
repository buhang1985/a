package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/// <summary>
/// <para>描    述 : 检验服务基础数据检查                    			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  BDLisSrvValidate					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  qzwang         				</para> 
/// <para>修 改 人 :  qzwang         				</para> 
/// <para>创建时间 :  10/19/2016 9:01:40 PM             </para>
/// <para>更新时间 :  10/19/2016 9:01:40 PM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
/// </summary>
public class BDLisSrvValidate extends BDSetSrvValidate {
	
	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(), medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList))
			info = errorList.get(errorList.size() - 1);
		
		if(medsrv.getFg_set()!=null && medsrv.getFg_set()==FBoolean.FALSE){
			MedSrvLisDO[] szMedSrvLisDO = ServiceFinder.find(IMedSrvLisDORService.class).find(String.format(" id_srv = '%s'", medsrv.getId_srv()), "", FBoolean.FALSE);
			if (szMedSrvLisDO==null || szMedSrvLisDO.length<=0){
	    		info.getDescList().add("检验属性表为空");
			}
	    	else{
	    		// CheckLisInfo(szMedSrvLisDO[0], info.getDescList()); // -- PO 暂时不检查
	    	}
		}
    	
		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}

	protected void CheckLisInfo(MedSrvLisDO s, List<String> e) {
		
        if (StringUtil.isEmpty(s.getId_samptp()))
        {
            e.add("标本类型为空");
        }
        if (StringUtil.isEmpty(s.getSd_samptp()))
        {
            e.add("标本类型编码为空");
        }
        if (StringUtil.isEmpty(s.getId_unit_quan()))
        {
            e.add("标本需求量单位为空");
        }
        if (StringUtil.isEmpty(s.getId_labgroup()))
        {
            e.add("检验分组为空");
        }
        if (StringUtil.isEmpty(s.getSd_labgroup()))
        {
            e.add("检验分组编码为空");
        }
        if (StringUtil.isEmpty(s.getId_contp()))
        {
            e.add("容器类型为空");
        }
        if (StringUtil.isEmpty(s.getSd_contp()))
        {
            e.add("容器类型编码为空");
        }

	}

	
}
