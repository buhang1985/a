package iih.en.doc.s.bp.preg.s;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.doc.endoc.d.EntDocDO;
import iih.en.doc.endoc.i.IDocCudService;
import iih.en.doc.endoc.i.IDocRService;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.PregDocStatDO;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.en.doc.pregdoc.i.IPregDocStatDOCudService;
import iih.en.doc.pregdoc.i.IPregdocMDOCudService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 预约保存 新增产妇状态
 * 
 * @author renzhi
 *
 */
public class ReserveSaveBP {

    /**
     * 
     * @param pregdocDto
     * @throws BizException
     */
    public void exec(PregDocDTO pregdocDto) throws BizException {
        // 产妇状态表PregDocStatDO
        this.validateParam(pregdocDto);
        EntDocDO entDocDO = this.newEntDocDo(pregdocDto);
        PregDocDO pregDocDO = this.saveEnDocPreg(pregdocDto,entDocDO);
        this.saveEnDocPregStat(pregDocDO);
    }
    

    /**
     * 验证传进来的对象是否为空
     * 
     * @param pregdocDto
     * @throws BizException
     */
    private void validateParam(PregDocDTO pregdocDto) throws BizException {
        if (pregdocDto == null) {
            throw new BizException(IEnMsgConst.ERROR_PREGDOC_NULL);
        }
    }
    
    /**
     * 获取就诊建档记录
     * @param pregdocDto
     * @throws BizException
     */
    private void getEntDocDo(PregDocDTO pregdocDto) throws BizException {
        IDocRService iDocRService = ServiceFinder.find(IDocRService.class);
    }

    /**
     * 创建就诊档案 保存表en_doc
     * 
     * @param pregdocDto
     * @throws BizException
     */
    private EntDocDO newEntDocDo(PregDocDTO pregdocDto) throws BizException {
        // 患者查询服务
        IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
        // 患者地址查询服务
        IPatiAddrDORService addrService = ServiceFinder.find(IPatiAddrDORService.class);
        // 就诊建档 命令服务
        IDocCudService docService = ServiceFinder.find(IDocCudService.class);
        // 患者agg服务
        IPatiRService iPatiRService = ServiceFinder.find(IPatiRService.class);
        // 获取到患者基本信息
        PatDO patDO = service.findById(pregdocDto.getId_pat());
        // 获取患者现住址
        PatiAddrDO[] addrDOs = addrService.findByAttrValString(PatiAddrDO.ID_PAT, patDO.getId_pat());
        PatiAddrDO patiAddrDO = this.getPatiAddrDO(addrDOs);
        
        
        // 新建就诊档案
        EntDocDO entDocDo = new EntDocDO();
        // 设置所属机构
        entDocDo.setId_org(patDO.getId_org());
        // 设置所属集团
        entDocDo.setId_grp(patDO.getId_grp());
        // 设置患者Id
        entDocDo.setId_pat(patDO.getId_pat());
        // 设置患者姓名
        entDocDo.setName_pat(patDO.getName());
        // 设置患者性别
        entDocDo.setId_sex(patDO.getId_sex());
        // 设置患者性别sd
        entDocDo.setSd_sex(patDO.getSd_sex());
        // 设置患者出生日期
        entDocDo.setDt_birth_pat(patDO.getDt_birth());
        // 设置婚姻状况主键
        entDocDo.setId_mari_pat(patDO.getId_marry());
        // 设置婚姻专题sd
        entDocDo.setSd_mari_pat(patDO.getSd_marry());
        // 设置电话
        entDocDo.setTelno_pat(patDO.getMob());
        entDocDo.setCode(patDO.getCode());
        // 设置为状态为新增
        entDocDo.setStatus(DOStatus.NEW);
        
        if (patiAddrDO != null) {
            entDocDo.setId_admdiv_addr(patiAddrDO.getId_pataddr());
            entDocDo.setSd_admdiv_addr(patiAddrDO.getSd_admdiv());
            entDocDo.setAddr_pat(patiAddrDO.getStreet());
        }
        
        //存入DB
        EntDocDO[] docDOs = docService.insert(new EntDocDO[] { entDocDo });
        return docDOs[0];
    }
    
    /**
     * 根据查询到的地址数组 获取到现住址
     * @param addrDOs
     * @return
     */
    private PatiAddrDO getPatiAddrDO(PatiAddrDO[] addrDOs) {
        for (PatiAddrDO patiAddrDO : addrDOs) {
            if (IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(patiAddrDO.getSd_addrtp())) {
                return patiAddrDO;
            }
        }
        return null;
    }

    /**
     * 创建产科建档 保存en_doc_preg
     * IPregdocMDOCudService
     * @param pregdocDto
     * @throws BizException 
     */
    public PregDocDO saveEnDocPreg(PregDocDTO pregdocDto,EntDocDO entDocDO) throws BizException {
        //产科建档service
        IPregdocMDOCudService service = ServiceFinder.find(IPregdocMDOCudService.class);
        //患者aggservice
        IPatiRService patAggService = ServiceFinder.find(IPatiRService.class);
        
        PatiAggDO patagg = patAggService.findById(entDocDO.getId_pat());
        PiPatContDO[] piPatContDOs = patagg.getPiPatContDO();
        PregDocDO pregDocDo = new PregDocDO();
        // 设置就诊建档主键
        pregDocDo.setId_entdoc(entDocDO.getId_entdoc());
        // 设置是否本院分娩
        pregDocDo.setFg_born_here(FBoolean.TRUE);
        // 设置配偶户籍主键
        pregDocDo.setId_admdiv_husb("~");
        // 设置配偶户籍编码
        pregDocDo.setSd_admdiv_husb("~");
        // 设置末次月经期
        pregDocDo.setD_last_menst(pregdocDto.getD_last_menst());
        // 设置预产期
        pregDocDo.setD_expect(pregdocDto.getD_expect());
        // 设置预约人
        pregDocDo.setId_emp_appt("");
        // 设置档案状态
        pregDocDo.setEu_status(pregdocDto.getEu_status());
        //
        pregDocDo.setPregdocstat("~");
        //设置预约期
        pregDocDo.setDt_appt(pregdocDto.getDt_appt());
        //获取当前时间
        pregDocDo.setDt_doc(new FDateTime());
        if (piPatContDOs != null && piPatContDOs.length!= 0) {
            // 设置患者联系人
            pregDocDo.setId_patcont(piPatContDOs[0].getId_cont());
        }
        //设置为新增状态
        pregDocDo.setStatus(DOStatus.NEW);
        PregDocDO[] pregDocDOs = service.insert(new PregDocDO[] {pregDocDo});
        return pregDocDOs[0];
    }

    /**
     * 创建产妇状态 保存en_doc_preg_stat
     * IPregDocStatDOCudService
     * @param pregdocDto
     * @throws BizException 
     */
    public void saveEnDocPregStat(PregDocDO pregDocDO) throws BizException {
        //产妇状态
        IPregDocStatDOCudService service = ServiceFinder.find(IPregDocStatDOCudService.class);
        PregDocStatDO statDo = new PregDocStatDO();
        //设置产科建档主键
        statDo.setId_pregdoc(pregDocDO.getId_pregdoc());
        //设置建档主键
        statDo.setId_entdoc(pregDocDO.getId_entdoc());
        //设置为新增状态
        statDo.setStatus(DOStatus.NEW);
        
        service.insert(new PregDocStatDO[] {statDo});
    }

}
