package iih.en.comm.bp;

import iih.en.comm.ep.EntContEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.pi.reg.pat.d.PiPatContDO;

import java.util.ArrayList;
import java.util.List;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊基本信息维护BP
 * 
 * @author zhengcm
 * @date 2016-07-01 14:10:03
 *
 */

public class OpBasicInfoBP {

	/**
	 * 设置联系人和代办人
	 * 
	 * @param dto 门诊基本信息维护DTO
	 * @param type 类型：0（全部）1（联系人）2（代办人）
	 * @throws BizException
	 */
	public void setContactInfo(OpBasic4EditDTO dto, int type) throws BizException {
		if (null == dto || EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		EntContDO[] entDOs = new EntContEP().getEntContByEntId(dto.getId_ent());
		if (EnValidator.isEmpty(entDOs)) {
			return;
		}
		for (EntContDO entDO : entDOs) {
			int emtype = entDO.getEu_entconttp();
			// 联系人
			if (type == 0 || type == EuEntContTp.CONTACT.intValue()) {
				if (EnValidator.isEmpty(dto.getName_cont())
						&& emtype == EuEntContTp.CONTACT.intValue()) {
					dto.setName_cont(entDO.getName());// 联系人名称
					dto.setId_patcont(entDO.getId_patcontid());// 联系人ID
					dto.setId_entcont(entDO.getId_entcont());
					dto.setSd_conttp(entDO.getSd_conttp());// 联系人类型编码
					dto.setId_conttp(entDO.getId_conttp());// 联系人类型ID
					dto.setName_conttp(entDO.getName_conttp());// 联系人类型名称
					dto.setConttel(entDO.getConttel());// 联系人电话
					dto.setContaddr(entDO.getContaddr());// 联系人地址
				}
			}
			// 代办人
			if (type == 0 || type == EuEntContTp.AGENT.intValue()) {
				if (EnValidator.isEmpty(dto.getName_cont_agent())
						&& emtype == EuEntContTp.AGENT.intValue()) {
					dto.setName_cont_agent(entDO.getName());// 代办人名称
					dto.setId_patcont_agent(entDO.getId_patcontid());// 代办人ID
					dto.setId_entcont_agent(entDO.getId_entcont());
					dto.setSd_conttp_agent(entDO.getSd_conttp());// 代办人类型编码
					dto.setId_conttp_agent(entDO.getId_conttp());// 代办人类型ID
					dto.setName_conttp_agent(entDO.getName_conttp());// 代办人类型名称
					dto.setConttel_agent(entDO.getConttel());// 代办人电话
					dto.setContaddr_agent(entDO.getContaddr());// 代办人地址
					dto.setId_idtp_agent(entDO.getId_idtp());// 代办人证件类型id
					dto.setSd_idtp_agent(entDO.getSd_idtp());// 代办人证件类型编码
					dto.setName_idtp_agent(entDO.getName_idtp());// 代办人证件类型名称
					dto.setIdcode_agent(entDO.getIdcode());// 证件号码
				}
			}
		}
	}

	/**
	 * 保存门诊基本信息联系人和代办人
	 * 
	 * @param dto 门诊基本信息维护DTO
	 * @param type 类型：0（全部）1（联系人）2（代办人）
	 * @throws BizException
	 */
	public OpBasic4EditDTO saveEntContInfo(OpBasic4EditDTO dto, int type) throws BizException {
		if (null == dto) {
			return dto;
		}
		// 保存患者联系人
		this.savePatContInfo(dto, type);
		// 就诊联系人List
		List<EntContDO> doList = new ArrayList<EntContDO>();
		// 序号
		int sortNo = this.getEntContMaxSortNoById(dto.getId_ent());
		// 就诊联系人DO对象
		EntContDO tempDO = null;
		if (type == 0 || type == EuEntContTp.CONTACT.intValue()) {
			// 联系人
			if (!EnValidator.isEmpty(dto.getId_entcont())) {
				// 联系人已存在
				tempDO = new EntContEP().getEntContById(dto.getId_entcont());
				if (null != tempDO) {
					if (!EnValidator.isEmpty(dto.getName_cont())) {
						// 更新联系人
						tempDO.setStatus(DOStatus.UPDATED);
						this.setEntContData(dto, tempDO, EuEntContTp.CONTACT.intValue());
						doList.add(tempDO);
					} else {
						// 删除联系人
						tempDO.setStatus(DOStatus.DELETED);
						doList.add(tempDO);
					}
				}
			} else {
				if (!EnValidator.isEmpty(dto.getName_cont())) {
					// 联系人不存在
					tempDO = new EntContDO();
					tempDO.setStatus(DOStatus.NEW);
					this.setEntContData(dto, tempDO, EuEntContTp.CONTACT.intValue());
					sortNo = sortNo + 1;
					tempDO.setSortno(sortNo);
					this.setPWMCode(tempDO);
					doList.add(tempDO);
				}
			}
		}
		if (type == 0 || type == EuEntContTp.AGENT.intValue()) {
			// 代办人
			if (!EnValidator.isEmpty(dto.getId_entcont_agent())) {
				// 代办人已存在
				tempDO = new EntContEP().getEntContById(dto.getId_entcont_agent());
				if (null != tempDO) {
					if (!EnValidator.isEmpty(dto.getName_cont_agent())) {
						// 更新代办人
						tempDO.setStatus(DOStatus.UPDATED);
						this.setEntContData(dto, tempDO, EuEntContTp.AGENT.intValue());
						doList.add(tempDO);
					} else {
						// 删除代办人
						tempDO.setStatus(DOStatus.DELETED);
						doList.add(tempDO);
					}
				}
			} else {
				if (!EnValidator.isEmpty(dto.getName_cont_agent())) {
					// 代办人不存在
					tempDO = new EntContDO();
					tempDO.setStatus(DOStatus.NEW);
					this.setEntContData(dto, tempDO, EuEntContTp.AGENT.intValue());
					sortNo = sortNo + 1;
					tempDO.setSortno(sortNo);
					this.setPWMCode(tempDO);
					doList.add(tempDO);
				}
			}
		}
		// 保存就诊联系人
		new EntContEP().saveEntContByStatus(doList);
		
		return  dto;
	}

	/**
	 * 同步更新患者联系人
	 * 
	 * @param dto 门诊基本信息维护DTO
	 * @param type 类型：0（全部）1（联系人）2（代办人）
	 * @throws BizException
	 */
	public void savePatContInfo(OpBasic4EditDTO dto, int type) throws BizException {
		EntContEP ep = new EntContEP();
		PiPatContDO contDO = null;
		int sortNo = this.geiPatContMaxSortNoById(dto.getId_pat());
		// 联系人
		if (type == 0 || type == EuEntContTp.CONTACT.intValue()) {
			if (!EnValidator.isEmpty(dto.getName_cont())) {
				if (!EnValidator.isEmpty(dto.getId_patcont())) {
					// 更新联系人对应的患者联系人
					contDO = ep.getPatContById(dto.getId_patcont());
					contDO.setStatus(DOStatus.UPDATED);
					this.setPatContData(dto, contDO, EuEntContTp.CONTACT.intValue());
					ep.updatePatContDO(contDO);
				} else {
					// 新增患者联系人
					contDO = new PiPatContDO();
					contDO.setStatus(DOStatus.NEW);
					this.setPatContData(dto, contDO, EuEntContTp.CONTACT.intValue());
					contDO.setId_pat(dto.getId_pat());
					sortNo = sortNo + 1;
					contDO.setSortno(sortNo);
					PiPatContDO tempDO = ep.insertPatContDO(contDO);
					// 回写就诊联系人数据
					dto.setId_patcont(tempDO.getId_patcont());
				}
			}
		}
		// 代办人
		if (type == 0 || type == EuEntContTp.AGENT.intValue()) {
			if (!EnValidator.isEmpty(dto.getName_cont_agent())) {
				if (!EnValidator.isEmpty(dto.getId_patcont_agent())) {
					// 更新代办人对应的患者联系人
					contDO = ep.getPatContById(dto.getId_patcont_agent());
					contDO.setStatus(DOStatus.UPDATED);
					this.setPatContData(dto, contDO, EuEntContTp.AGENT.intValue());
					ep.updatePatContDO(contDO);
				} else {
					// 新增患者联系人
					contDO = new PiPatContDO();
					contDO.setStatus(DOStatus.NEW);
					this.setPatContData(dto, contDO, EuEntContTp.AGENT.intValue());
					contDO.setId_pat(dto.getId_pat());
					sortNo = sortNo + 1;
					contDO.setSortno(sortNo);
					PiPatContDO tempDO = ep.insertPatContDO(contDO);
					// 回写就诊联系人数据
					dto.setId_patcont_agent(tempDO.getId_patcont());
				}
			}
		}
	}

	/**
	 * 根据门诊基本信息DO数据设置患者联系人数据
	 * 
	 * @param dto 门诊基本信息维护DTO
	 * @param contDO 患者联系人DO
	 * @param type 类型：1（联系人）2（代办人）
	 * @throws BizException
	 */
	private void setPatContData(OpBasic4EditDTO dto, PiPatContDO contDO, int type)
			throws BizException {
		if (null == contDO) {
			return;
		}
		if (type == EuEntContTp.CONTACT.intValue()) {
			// 联系人
			contDO.setName(dto.getName_cont());
			contDO.setConttp_name(dto.getName_conttp());
			contDO.setSd_conttp(dto.getSd_conttp());
			contDO.setId_conttp(dto.getId_conttp());
			contDO.setContaddr(dto.getContaddr());
			contDO.setConttel(dto.getConttel());
		} else if (type == EuEntContTp.AGENT.intValue()) {
			// 代办人
			contDO.setName(dto.getName_cont_agent());
			contDO.setConttp_name(dto.getName_conttp_agent());
			contDO.setId_conttp(dto.getId_conttp_agent());
			contDO.setSd_conttp(dto.getSd_conttp_agent());
			contDO.setId_cont(dto.getId_idtp_agent());
			contDO.setSd_cont(dto.getSd_idtp_agent());
			contDO.setContid(dto.getIdcode_agent());
			contDO.setConttel(dto.getConttel_agent());
			if (!EnValidator.isEmpty(dto.getContaddr_agent())) {
				contDO.setContaddr(dto.getContaddr_agent());
			}
		}
	}

	/**
	 * 根据门诊基本信息DO设置就诊联系人DO数据
	 * 
	 * @param dto 门诊基本信息维护DTO
	 * @param contDO 就诊联系人DO
	 * @param type 类型：1（联系人）2（代办人）
	 * @throws BizException
	 */
	private void setEntContData(OpBasic4EditDTO dto, EntContDO contDO, int type)
			throws BizException {
		if (null == contDO) {
			return;
		}
		if (type == EuEntContTp.CONTACT.intValue()) {
			// 联系人
			contDO.setName(dto.getName_cont());
			contDO.setConttel(dto.getConttel());
			contDO.setContaddr(dto.getContaddr());
			contDO.setId_conttp(dto.getId_conttp());
			contDO.setSd_conttp(dto.getSd_conttp());
			contDO.setId_patcontid(dto.getId_patcont());
			if (contDO.getStatus() == DOStatus.NEW) {
				contDO.setId_ent(dto.getId_ent());
				contDO.setEu_entconttp(EuEntContTp.CONTACT.intValue());
			}
		} else if (type == EuEntContTp.AGENT.intValue()) {
			// 代办人
			contDO.setName(dto.getName_cont_agent());
			contDO.setId_conttp(dto.getId_conttp_agent());
			contDO.setSd_conttp(dto.getSd_conttp_agent());
			contDO.setConttel(dto.getConttel_agent());
			if (!EnValidator.isEmpty(dto.getContaddr_agent())) {
				contDO.setContaddr(dto.getContaddr_agent());
			}
			contDO.setId_patcontid(dto.getId_patcont_agent());
			contDO.setIdcode(dto.getIdcode_agent());
			contDO.setId_idtp(dto.getId_idtp_agent());
			contDO.setSd_idtp(dto.getSd_idtp_agent());
			if (contDO.getStatus() == DOStatus.NEW) {
				contDO.setId_ent(dto.getId_ent());
				contDO.setEu_entconttp(EuEntContTp.AGENT.intValue());
			}
		}
	}

	/**
	 * 设置拼音、五笔、助记码
	 * 
	 * @param contDO 就诊联系人DO
	 * @throws BizException
	 */
	private void setPWMCode(EntContDO contDO) throws BizException {
		if (null == contDO || EnValidator.isEmpty(contDO.getName())) {
			return;
		}
		// 拼音
		contDO.setPycode(CnToPy.getPyFirstCode(contDO.getName()));
		// 五笔
		contDO.setWbcode(CnToWB.getWBCode(contDO.getName()));
		// 助记码
		contDO.setMnecode(contDO.getPycode());
	}

	/**
	 * 根据患者ID查询患者联系人最大序号
	 *
	 * @param id_pat 患者ID
	 * @return 患者联系人最大序号值
	 * @throws BizException
	 */
	private int geiPatContMaxSortNoById(String id_pat) throws BizException {
		int sortNo = 0;
		if (!EnValidator.isEmpty(id_pat)) {
			String sql = "SELECT MAX(SORTNO) AS SORTNO FROM PI_PAT_CONT WHERE ID_PAT = ? ";
			SqlParam param = new SqlParam();
			param.addParam(id_pat);
			sortNo = this.queryMaxBySql(sql, param);
		}
		return sortNo;
	}

	/**
	 * 根据就诊ID查询就诊联系人最大序号值
	 *
	 * @param id_ent 就诊ID
	 * @return 就诊联系人最大序号值
	 * @throws BizException
	 */
	private int getEntContMaxSortNoById(String id_ent) throws BizException {
		int sortNo = 0;
		if (!EnValidator.isEmpty(id_ent)) {
			String sql = "SELECT MAX(SORTNO) AS SORTNO FROM EN_ENT_CONT WHERE ID_ENT = ? ";
			SqlParam param = new SqlParam();
			param.addParam(id_ent);
			sortNo = this.queryMaxBySql(sql, param);
		}
		return sortNo;
	}

	/**
	 * 执行SQL查询序号
	 * 
	 * @param sql SQL语句
	 * @return 最大序号
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked" })
	private int queryMaxBySql(String sql, SqlParam param) throws BizException {
		int sortNo = 0;
		Integer count = (Integer) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if (count != null) {
			return count;
		}
		return sortNo;
	}

}
