package iih.ci.preop.ems.lis;

import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.preop.ems.base.BasePreOpEmsSaveBP;
import iih.ci.preop.ems.d.EmsLisViewDTO;
import iih.ci.preop.ems.d.b.BasePreOpEmsViewDTO;
import iih.ci.sdk.cache.BDSampcolTimeInfoCache;
import iih.ci.sdk.orctt.CiOrContentUtils;
import iih.ci.sdk.orctt.meta.LisOrContentParam;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.i.ICitsaplabCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验预住院申请医嘱保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsLisSaveBP extends BasePreOpEmsSaveBP {

	@Override
	protected void afterSaveTsOrderAggInfo(CiEnContextDTO ctx,CitsorderAggDO aggD,BasePreOpEmsViewDTO emsViewDto) throws BizException {
		CiTsApLabDO ciTsApLabDo=new CiTsApLabDO();
		ciTsApLabDo.setStatus(DOStatus.NEW);
		ciTsApLabDo.setId_tsor(aggD.getParentDO().getId_tsor());
		this.mergeCiTsOrdAppInfo(ciTsApLabDo, emsViewDto);
		ServiceFinder.find(ICitsaplabCudService.class).save(new CiTsApLabDO[]{ciTsApLabDo});
	}
	@Override
	protected void mergeCiTsOrdAppInfo(Object ciTsApInfoDo,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		CiTsApLabDO ciTsApLabDo=(CiTsApLabDO)ciTsApInfoDo;
		EmsLisViewDTO lisViewDto=(EmsLisViewDTO)emsViewDto;
//		ciTsApLabDo.setId_tsaplab();	            //治疗方案检验申请ID	
//		ciTsApLabDo.setId_tsor();	                //治疗方案医嘱ID
		ciTsApLabDo.setId_samptp(lisViewDto.getId_samptp());	            //标本类型ID
		ciTsApLabDo.setSd_samptp(lisViewDto.getSd_samptp());	            //标本类型SD
		ciTsApLabDo.setName_samptp(lisViewDto.getName_samptp());	            //标本类型名称	
		if(!ObjectUtils.isEmpty(lisViewDto.getId_sampcoltime())){
			SampCollectTimeDictDO sampColTimeDo=BDSampcolTimeInfoCache.GetBDSampcolTimeInfo(lisViewDto.getId_sampcoltime());
			ciTsApLabDo.setId_sampcoltime(lisViewDto.getId_sampcoltime());	        //标本采集时间ID	
			ciTsApLabDo.setName_sampcoltime(lisViewDto.getName_sampcoltime());	    //标本采集时间
			ciTsApLabDo.setId_sampcollecttimetp(sampColTimeDo.getId_sampcollecttimetp());	//标本采集时间类型ID	
			ciTsApLabDo.setSd_sampcollecttimetp(sampColTimeDo.getSd_sampcollecttimetp());	//标本采集时间类型编码
			ciTsApLabDo.setLen_sampcoltime(sampColTimeDo.getLen_time());	        //标本采集时长	
			ciTsApLabDo.setId_unit_sampcoltime(sampColTimeDo.getId_unit_time());	    //标本采集时长单位	
		}
		
	}
	/**
	 * 医嘱内容拼接
	 * @param tsOrdAggDO
	 * @return
	 * @throws BizException 
	 */
	@Override
	protected CiOrContentDO setOrContentInfo(CitsorderAggDO tsOrdAggDO,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		LisOrContentParam param=new LisOrContentParam();
		EmsLisViewDTO lisViewDto=(EmsLisViewDTO)emsViewDto;
		param.setName_srv(lisViewDto.getName_srv());
		param.setPri(lisViewDto.getPri());
		param.setIsmuldose(FBoolean.FALSE);
		param.setIsmulexec(FBoolean.FALSE);
		param.setSd_srvtp(lisViewDto.getSd_srvtp());
		param.setQuan_med(lisViewDto.getQuan_med());
		param.setName_unit_med(lisViewDto.getName_unit_med());
		param.setName_freq(lisViewDto.getName_freq());
		param.setDays_or(lisViewDto.getDays_or());
		param.setFg_urgent(FBoolean.FALSE);
		param.setName_samptp(lisViewDto.getName_samptp());
		param.setSd_nodispense(lisViewDto.getSd_nodispense());
		return CiOrContentUtils.create(param);
	}
}
