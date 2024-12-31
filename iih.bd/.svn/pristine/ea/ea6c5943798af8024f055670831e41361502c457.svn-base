package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/// <summary>
/// <para>描    述 :  检查服务基础数据检查                    			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  Class2					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  BDRisSrvValidate         				</para> 
/// <para>修 改 人 :  BDRisSrvValidate         				</para> 
/// <para>创建时间 :  10/19/2016 9:00:42 PM             </para>
/// <para>更新时间 :  10/19/2016 9:00:42 PM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
/// </summary>
public class BDRisSrvValidate extends BDSetSrvValidate {

	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(), medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList))
			info = errorList.get(errorList.size() - 1);
		// 检查属性
		
		if(medsrv.getFg_set()!=null && medsrv.getFg_set()==FBoolean.FALSE){
			MedSrvRisDO[] szMedSrvRisDO = ServiceFinder.find(IMedSrvRisDORService.class).find(String.format(" id_srv = '%s'", medsrv.getId_srv()), "", FBoolean.FALSE);
			if (szMedSrvRisDO == null || szMedSrvRisDO.length<=0){
				info.getDescList().add("检查属性表为空");
			}
			else {
				// CheckRisInfo(szMedSrvRisDO[0], info.getDescList());// -- 根据需求要求不再检查
			}
		}
		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}

	protected void CheckRisInfo(MedSrvRisDO s, List<String> e) {
		
        if (StringUtil.isEmpty(s.getId_body()))
        {
            e.add("身体部位为空");
        }
		if (StringUtil.isEmpty(s.getSd_body())){
			e.add("身体部位编码为空");
		}
		if(s.getFg_body_update().equals(null)){
			e.add("部位可修改标识为空");
		}
		if(s.getIf_mp_bed().equals(null)){
			e.add("是否床边执行标识为空");
		}

	}
}
