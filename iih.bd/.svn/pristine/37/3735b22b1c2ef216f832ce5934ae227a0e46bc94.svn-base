package iih.bd.srv.medsrv.s.rule;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.medsrv.i.IRelsrvtacticsRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

public class RelSrvTacticCheckRule implements IRule<RelSrvTacticDO>{

	@Override
	public void process(RelSrvTacticDO... arg0) throws BizException {
		// TODO Auto-generated method stub
		IRelsrvtacticsRService relsrvtacticsRService = ServiceFinder.find(IRelsrvtacticsRService.class);
		for (RelSrvTacticDO relSrvTacticDO : arg0) {
			String whereStr = "";
			//类型为：01服务
			if(relSrvTacticDO.getSd_relfactortp().equals(IBdSrvDictCodeConst.SD_RELFACTORTP_SRV)){
				whereStr += " id_biz = '"+relSrvTacticDO.getId_biz()+"' AND id_srv = '"+relSrvTacticDO.getId_srv()+"' ";
				RelSrvTacticDO[] result = relsrvtacticsRService.find(whereStr, "", FBoolean.FALSE);
				if(result!=null&&result.length>0){
					throw new BizException("关联因素类型为服务时，服务:"+result[0].getSrvname()+"，关联服务:"+result[0].getRelsrvname()+"需满足唯一性。");
				}
			}else if(relSrvTacticDO.getSd_relfactortp().equals(IBdSrvDictCodeConst.SD_RELFACTORTP_SETSETITM)){//类型为：02 套+套内项目
//				if(relSrvTacticDO.getId_bizitm() == null)
//					throw new BizException("关联因素类型为 套+套内项目时，套内项目为必填项");
				whereStr += " id_biz = '"+relSrvTacticDO.getId_biz()+"' AND id_bizitm = '"+relSrvTacticDO.getId_bizitm()+"' AND id_srv = '"+relSrvTacticDO.getId_srv()+"' ";
				RelSrvTacticDO[] result = relsrvtacticsRService.find(whereStr, "", FBoolean.FALSE);
				if(result!=null&&result.length>0){
					throw new BizException("关联因素类型为 套+套内项目时，服务:"+result[0].getSrvname()+"，套内项目："+result[0].getSrvitemname()+"，关联服务:"+result[0].getRelsrvname()+"需满足唯一性。");
				}
			}
		}
	}
}
