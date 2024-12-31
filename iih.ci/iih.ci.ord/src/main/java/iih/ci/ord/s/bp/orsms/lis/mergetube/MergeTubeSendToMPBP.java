package iih.ci.ord.s.bp.orsms.lis.mergetube;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.opmergetube.d.SampleOrRelDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 检验合管同步到执行域
 * @author zhangwq
 *
 */
public class MergeTubeSendToMPBP {
	public void exec(CiEnContextDTO ctx,CiapplissheetAggDO[] lissheets) throws BizException{
		LogUtils.Logger("检验签署后调用执行域同步合管数据，CiapplissheetAggDO数量："+lissheets.length+"----------");
		if(lissheets==null||lissheets.length==0){
			return;
		}
		FBoolean isSendToMp = isSendToMp(ctx.getId_org());
		LogUtils.Logger("检验签署后调用执行域同步合管数据，是否同步到执行域"+(FBoolean.TRUE.equals(isSendToMp)));
		if(FBoolean.TRUE.equals(isSendToMp)){
			LogUtils.Logger("检验签署后调用执行域同步合管数据，同步到执行域");
			IForeignService servcice = ServiceFinder.find(IForeignService.class);
			List<SampleOrRelDTO> params = new ArrayList<SampleOrRelDTO>();
			for(CiapplissheetAggDO sheetAgg : lissheets){
				SampleOrRelDTO reldto = new SampleOrRelDTO();
				params.add(reldto);
				reldto.setNo_bar(sheetAgg.getParentDO().getCode_app());
				List<String> idorlist = new ArrayList<String>();
				CiAppLisSheetOrDO[] sheetOrs = sheetAgg.getCiAppLisSheetOrDO();
				if(sheetOrs!=null){
					for(CiAppLisSheetOrDO sheetor : sheetOrs){
						idorlist.add(sheetor.getId_or());
						LogUtils.Logger("检验签署后调用执行域同步合管数据，是否同步到执行域的医嘱"+sheetor.getId_or());
					}
				}
				reldto.setListOrs(idorlist);
			}
			servcice.opMergerTube(params.toArray(new SampleOrRelDTO[0]));
		}
	}
	public void exec(String id_org,CiapplissheetAggDO[] lissheets) throws BizException{
		if(lissheets==null||lissheets.length==0){
			return;
		}
		if(FBoolean.TRUE.equals(isSendToMp(id_org))){
			IForeignService servcice = ServiceFinder.find(IForeignService.class);
			List<SampleOrRelDTO> params = new ArrayList<SampleOrRelDTO>();
			for(CiapplissheetAggDO sheetAgg : lissheets){
				SampleOrRelDTO reldto = new SampleOrRelDTO();
				params.add(reldto);
				reldto.setNo_bar(sheetAgg.getParentDO().getCode_app());
				List<String> idorlist = new ArrayList<String>();
				CiAppLisSheetOrDO[] sheetOrs = sheetAgg.getCiAppLisSheetOrDO();
				if(sheetOrs!=null){
					for(CiAppLisSheetOrDO sheetor : sheetOrs){
						idorlist.add(sheetor.getId_or());
					}
				}
				reldto.setListOrs(idorlist);
			}
			servcice.opMergerTube(params.toArray(new SampleOrRelDTO[0]));
		}
	}
	public void exec(List<String> id_ors) throws BizException{}
	protected FBoolean isSendToMp(String id_org){
		try{
			return ParamsetQryUtil.getParaBoolean(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_MERGETBUSENDTOMP);
		}catch(Exception ex){
			return FBoolean.FALSE;
		}
			
	}
}
