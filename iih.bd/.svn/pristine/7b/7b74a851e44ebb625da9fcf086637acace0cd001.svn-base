package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.i.IMedSrvVtDORService;
import iih.bd.srv.s.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 生命特征服务基础信息检验
 * @author vivi
 *
 */
public class BDVitalSignsSrvValidate extends BDSetSrvValidate {

	@Override
	public Boolean CheckValidate(MedSrvDO srv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(srv.getId_srv(),srv.getName());
		if (!super.CheckValidate(srv, errorList))
			info = errorList.get(errorList.size() - 1);
		
		MedSrvVtDO[] szMedSrvVtDO = ServiceFinder.find(IMedSrvVtDORService.class).find(String.format(" id_srv = '%s'", srv.getId_srv()),"",FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(szMedSrvVtDO)){
			info.getDescList().add("生命体征属性表为空");
		}
		else{
			// CheckVitalInfo(szMedSrvVtDO[0], info.getDescList()); // -- 根据需要要求，暂时不再检查
		}
		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}

	protected void CheckVitalInfo(MedSrvVtDO s, List<String> e) {
		if (StringUtil.isEmpty(s.getId_de()))
        {
            e.add("公共数据元为空");
        }
		if (StringUtil.isEmpty(s.getId_dedatatp()))
        {
            e.add("数据类型为空");
        }
		if (StringUtil.isEmpty(s.getSd_dedatatp()))
        {
            e.add("数据类型编码为空");
        }
	}

}
