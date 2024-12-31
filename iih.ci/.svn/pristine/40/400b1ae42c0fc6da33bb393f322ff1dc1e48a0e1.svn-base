package iih.ci.preop.ems;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.utils.UdidocUtils;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ems.b.BaseOrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.i.meta.KeyValueDTO;
import iih.ci.preop.ems.lis.EmsLisDriver;
import iih.ci.preop.ems.ris.EmsRisDriver;
import iih.ci.preop.ems.treat.EmsTreatDriver;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.driver.BaseEmsDriver;
import iih.ci.sdk.utils.ReflClassUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 门诊预住院申请医疗单主服务接口实现
 * 
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiPreOPEmsMainService.class }, binding = Binding.JSONRPC)
public class CiPreOPEmsMainServiceImpl implements ICiPreOPEmsMainService {

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		// TODO Auto-generated method stub
		if (ObjectUtils.isEmpty(arg)) {
			throw new BizException("调用预住院申请医疗单接口，没有给定入参");
		}

		BaseEmsDriver driver = this.whitchDriver(ctx, arg.getSd_srvtp());
		if (ObjectUtils.isEmpty(driver)) {
			throw new BizException("匹配预住院申请医疗单驱动失败");
		}

		EmsRstDTO rstInfo = driver.create(ctx, arg);

		if (ObjectUtils.isEmpty(rstInfo)) {
			throw new BizException("内部创建逻辑并没有返回任何值");
		}

		return rstInfo;
	}

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		// 有效性判断逻辑
		if (ObjectUtils.isEmpty(arg) || ObjectUtils.isEmpty(arg.getCode_or())) {
			throw new BizException("调用预住院申请单加载逻辑，参数为空");
		}
		
		
		// 查询申请单服务类型
		String sd_srvtp = new SqlParamBuilder("select sd_srvtp from ci_ts_or ").where("code_or", arg.getCode_or()).V("sd_srvtp");

		if(ObjectUtils.isEmpty(sd_srvtp)) {
			throw new BizException("查询改申请单类型失败");
		}
		
		BaseEmsDriver driver = this.whitchDriver(ctx, sd_srvtp);
		if (ObjectUtils.isEmpty(driver)) {
			throw new BizException("匹配预住院申请医疗单驱动失败");
		}

		EmsRstDTO rstInfo = driver.load(ctx, arg);

		if (ObjectUtils.isEmpty(rstInfo)) {
			throw new BizException("内部加载逻辑并没有返回任何值");
		}

		return rstInfo;
	}

	@Override
	public EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException {
		// 有效性判断逻辑
		if (ObjectUtils.isEmpty(arg) || ObjectUtils.isEmpty(arg.getDocument())) {
			throw new BizException("调用预住院申请单保存逻辑，参数为空");
		}
		BaseOrderListViewDTO emsInfo = (BaseOrderListViewDTO) arg.getDocument().get(0);
		if (ObjectUtils.isEmpty(emsInfo.getDriverInfo())) {
			throw new BizException("调用预住院申请单保存逻辑，驱动信息为空");
		}

		String sd_srvtp = ((BaseOrderListViewDTO) arg.getDocument().get(0)).getSd_srvtp();

		BaseEmsDriver driver = this.whitchDriver(ctx, sd_srvtp);
		if (ObjectUtils.isEmpty(driver)) {
			throw new BizException("匹配预住院申请医疗单驱动失败");
		}

		EmsRstDTO rstInfo = driver.save(ctx, arg);

		if (ObjectUtils.isEmpty(rstInfo)) {
			throw new BizException("内部保存逻辑并没有返回任何值");
		}

		return rstInfo;
	}

	/**
	 * 匹配保存医疗单
	 * 
	 * @param ctx
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected EmsRstDTO matchSaveEmsDriver(CiEnContextDTO ctx, EmsSaveDTO ems) throws BizException {

		EmsRstDTO[] szRstInfo = ReflClassUtils.ReflCallWith(ems.getDriverInfo().getEmsBackendDriver(), "save", ctx,
				EmsSaveDTO[].class, new EmsSaveDTO[] { ems });
		return szRstInfo[0];
	}

	/**
	 * 定向创建医疗单驱动器
	 * 
	 * @param ctx
	 * @param sd_srvtp
	 * @return
	 */
	private BaseEmsDriver whitchDriver(CiEnContextDTO ctx, String sd_srvtp) throws BizException {
		// 有效性判断逻辑
		if (ObjectUtils.isEmpty(sd_srvtp)) {
			throw new BizException("创建预住院申请单没给给定服务类型(sd_srvtp)");
		}

		// 预住院检验申请单驱动固定识别
		if (sd_srvtp.startsWith("03")) {
			return new EmsLisDriver();
		}

		// 预住院检查申请单后台驱动固定识别
		if (sd_srvtp.startsWith("02") && !sd_srvtp.startsWith("0207")) {
			return new EmsRisDriver();
		}

		// 预住院治疗申请单固定识别
		// 预住院检验申请单驱动固定识别
		if (sd_srvtp.startsWith("05")) {
			return new EmsTreatDriver();
		}

		return null;
	}

	@Override
	public EmsRstDTO getFilterSrvtp4Ref() throws BizException {
		// TODO Auto-generated method stub
		// select t.id_udidoc, t.name name_udidoc,t.ctrl1 filter_srvtp from bd_udidoc t
		// where t.id_udidoclist = '@@@@ZZ20000000000125';
		// IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE
		EmsRstDTO rstInfo = new EmsRstDTO();
		rstInfo.setDocument(new FArrayList());
		UdidocDO[] szUdidocs = UdidocUtils.getUdidocByTpCode(ICiDictCodeConst.CODE_ORDER_CREATE_EMS_TYPE);
		for (UdidocDO item : szUdidocs) {
			if (!ObjectUtils.isEmpty(item.getCtrl2())
					&& item.getCtrl2().contains(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE)) {
				rstInfo.getDocument().add(new KeyValueDTO(item.getName(), item.getCtrl1()));
			}
		}
		return rstInfo;
	}
}
