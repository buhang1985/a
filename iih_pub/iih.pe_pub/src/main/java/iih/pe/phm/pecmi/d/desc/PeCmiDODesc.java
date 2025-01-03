
package iih.pe.phm.pecmi.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 体检康奈尔医学指数 DO 元数据信息
 */
public class PeCmiDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pecmi.d.PeCmiDO";
	public static final String CLASS_DISPALYNAME = "体检康奈尔医学指数";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pecmi";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pecmi";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeCmiDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_pecmiADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pecmiADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getA1ADesc(tblDesc));
		this.add(getA2ADesc(tblDesc));
		this.add(getA3ADesc(tblDesc));
		this.add(getA4ADesc(tblDesc));
		this.add(getA5ADesc(tblDesc));
		this.add(getA6ADesc(tblDesc));
		this.add(getA7ADesc(tblDesc));
		this.add(getA8ADesc(tblDesc));
		this.add(getA9ADesc(tblDesc));
		this.add(getB10ADesc(tblDesc));
		this.add(getB11ADesc(tblDesc));
		this.add(getB12ADesc(tblDesc));
		this.add(getB13ADesc(tblDesc));
		this.add(getB14ADesc(tblDesc));
		this.add(getB15ADesc(tblDesc));
		this.add(getB16ADesc(tblDesc));
		this.add(getB17ADesc(tblDesc));
		this.add(getB18ADesc(tblDesc));
		this.add(getB19ADesc(tblDesc));
		this.add(getB20ADesc(tblDesc));
		this.add(getB21ADesc(tblDesc));
		this.add(getB22ADesc(tblDesc));
		this.add(getB23ADesc(tblDesc));
		this.add(getB24ADesc(tblDesc));
		this.add(getB25ADesc(tblDesc));
		this.add(getB26ADesc(tblDesc));
		this.add(getB27ADesc(tblDesc));
		this.add(getC28ADesc(tblDesc));
		this.add(getC29ADesc(tblDesc));
		this.add(getC30ADesc(tblDesc));
		this.add(getC31ADesc(tblDesc));
		this.add(getC32ADesc(tblDesc));
		this.add(getC33ADesc(tblDesc));
		this.add(getC34ADesc(tblDesc));
		this.add(getC35ADesc(tblDesc));
		this.add(getC36ADesc(tblDesc));
		this.add(getC37ADesc(tblDesc));
		this.add(getC38ADesc(tblDesc));
		this.add(getC39ADesc(tblDesc));
		this.add(getC40ADesc(tblDesc));
		this.add(getD41ADesc(tblDesc));
		this.add(getD42ADesc(tblDesc));
		this.add(getD43ADesc(tblDesc));
		this.add(getD44ADesc(tblDesc));
		this.add(getD45ADesc(tblDesc));
		this.add(getD46ADesc(tblDesc));
		this.add(getD47ADesc(tblDesc));
		this.add(getD48ADesc(tblDesc));
		this.add(getD49ADesc(tblDesc));
		this.add(getD50ADesc(tblDesc));
		this.add(getD51ADesc(tblDesc));
		this.add(getD52ADesc(tblDesc));
		this.add(getD53ADesc(tblDesc));
		this.add(getD54ADesc(tblDesc));
		this.add(getD55ADesc(tblDesc));
		this.add(getD56ADesc(tblDesc));
		this.add(getD57ADesc(tblDesc));
		this.add(getD58ADesc(tblDesc));
		this.add(getD59ADesc(tblDesc));
		this.add(getD60ADesc(tblDesc));
		this.add(getD61ADesc(tblDesc));
		this.add(getD62ADesc(tblDesc));
		this.add(getD63ADesc(tblDesc));
		this.add(getE64ADesc(tblDesc));
		this.add(getE65ADesc(tblDesc));
		this.add(getE66ADesc(tblDesc));
		this.add(getE67ADesc(tblDesc));
		this.add(getE68ADesc(tblDesc));
		this.add(getE69ADesc(tblDesc));
		this.add(getE70ADesc(tblDesc));
		this.add(getE71ADesc(tblDesc));
		this.add(getF72ADesc(tblDesc));
		this.add(getF73ADesc(tblDesc));
		this.add(getF74ADesc(tblDesc));
		this.add(getF75ADesc(tblDesc));
		this.add(getF76ADesc(tblDesc));
		this.add(getF77ADesc(tblDesc));
		this.add(getF78ADesc(tblDesc));
		this.add(getG79ADesc(tblDesc));
		this.add(getG80ADesc(tblDesc));
		this.add(getG81ADesc(tblDesc));
		this.add(getG82ADesc(tblDesc));
		this.add(getG83ADesc(tblDesc));
		this.add(getG84ADesc(tblDesc));
		this.add(getG85ADesc(tblDesc));
		this.add(getG86ADesc(tblDesc));
		this.add(getG87ADesc(tblDesc));
		this.add(getG88ADesc(tblDesc));
		this.add(getG89ADesc(tblDesc));
		this.add(getG90ADesc(tblDesc));
		this.add(getG91ADesc(tblDesc));
		this.add(getG92ADesc(tblDesc));
		this.add(getG93ADesc(tblDesc));
		this.add(getG94ADesc(tblDesc));
		this.add(getG95ADesc(tblDesc));
		this.add(getG96ADesc(tblDesc));
		this.add(getH97mADesc(tblDesc));
		this.add(getH98mADesc(tblDesc));
		this.add(getH99mADesc(tblDesc));
		this.add(getH100mADesc(tblDesc));
		this.add(getH101mADesc(tblDesc));
		this.add(getH102mADesc(tblDesc));
		this.add(getH97wADesc(tblDesc));
		this.add(getH98wADesc(tblDesc));
		this.add(getH99wADesc(tblDesc));
		this.add(getH100wADesc(tblDesc));
		this.add(getH101wADesc(tblDesc));
		this.add(getH102wADesc(tblDesc));
		this.add(getH103ADesc(tblDesc));
		this.add(getH104ADesc(tblDesc));
		this.add(getH105ADesc(tblDesc));
		this.add(getH106ADesc(tblDesc));
		this.add(getH107ADesc(tblDesc));
		this.add(getI108ADesc(tblDesc));
		this.add(getI109ADesc(tblDesc));
		this.add(getI110ADesc(tblDesc));
		this.add(getI111ADesc(tblDesc));
		this.add(getI112ADesc(tblDesc));
		this.add(getI113ADesc(tblDesc));
		this.add(getI114ADesc(tblDesc));
		this.add(getJ115ADesc(tblDesc));
		this.add(getJ116ADesc(tblDesc));
		this.add(getJ117ADesc(tblDesc));
		this.add(getJ118ADesc(tblDesc));
		this.add(getJ119ADesc(tblDesc));
		this.add(getJ120ADesc(tblDesc));
		this.add(getJ121ADesc(tblDesc));
		this.add(getJ122ADesc(tblDesc));
		this.add(getJ123ADesc(tblDesc));
		this.add(getK124ADesc(tblDesc));
		this.add(getK125ADesc(tblDesc));
		this.add(getK126ADesc(tblDesc));
		this.add(getK127ADesc(tblDesc));
		this.add(getK128ADesc(tblDesc));
		this.add(getK129ADesc(tblDesc));
		this.add(getK130ADesc(tblDesc));
		this.add(getK131ADesc(tblDesc));
		this.add(getK132ADesc(tblDesc));
		this.add(getK133ADesc(tblDesc));
		this.add(getK134ADesc(tblDesc));
		this.add(getK135ADesc(tblDesc));
		this.add(getK136ADesc(tblDesc));
		this.add(getK137ADesc(tblDesc));
		this.add(getK138ADesc(tblDesc));
		this.add(getL139ADesc(tblDesc));
		this.add(getL140ADesc(tblDesc));
		this.add(getL141ADesc(tblDesc));
		this.add(getL142ADesc(tblDesc));
		this.add(getL143ADesc(tblDesc));
		this.add(getL144ADesc(tblDesc));
		this.add(getM145ADesc(tblDesc));
		this.add(getM146ADesc(tblDesc));
		this.add(getM147ADesc(tblDesc));
		this.add(getM148ADesc(tblDesc));
		this.add(getM149ADesc(tblDesc));
		this.add(getM150ADesc(tblDesc));
		this.add(getM151ADesc(tblDesc));
		this.add(getM152ADesc(tblDesc));
		this.add(getM153ADesc(tblDesc));
		this.add(getM154ADesc(tblDesc));
		this.add(getM155ADesc(tblDesc));
		this.add(getM156ADesc(tblDesc));
		this.add(getN157ADesc(tblDesc));
		this.add(getN158ADesc(tblDesc));
		this.add(getN159ADesc(tblDesc));
		this.add(getN160ADesc(tblDesc));
		this.add(getN161ADesc(tblDesc));
		this.add(getN162ADesc(tblDesc));
		this.add(getO163ADesc(tblDesc));
		this.add(getO164ADesc(tblDesc));
		this.add(getO165ADesc(tblDesc));
		this.add(getO166ADesc(tblDesc));
		this.add(getO167ADesc(tblDesc));
		this.add(getO168ADesc(tblDesc));
		this.add(getO169ADesc(tblDesc));
		this.add(getO170ADesc(tblDesc));
		this.add(getO171ADesc(tblDesc));
		this.add(getP172ADesc(tblDesc));
		this.add(getP173ADesc(tblDesc));
		this.add(getP174ADesc(tblDesc));
		this.add(getP175ADesc(tblDesc));
		this.add(getP176ADesc(tblDesc));
		this.add(getP177ADesc(tblDesc));
		this.add(getQ178ADesc(tblDesc));
		this.add(getQ179ADesc(tblDesc));
		this.add(getQ180ADesc(tblDesc));
		this.add(getQ181ADesc(tblDesc));
		this.add(getQ182ADesc(tblDesc));
		this.add(getQ183ADesc(tblDesc));
		this.add(getQ184ADesc(tblDesc));
		this.add(getQ185ADesc(tblDesc));
		this.add(getQ186ADesc(tblDesc));
		this.add(getR187ADesc(tblDesc));
		this.add(getR188ADesc(tblDesc));
		this.add(getR189ADesc(tblDesc));
		this.add(getR190ADesc(tblDesc));
		this.add(getR191ADesc(tblDesc));
		this.add(getR192ADesc(tblDesc));
		this.add(getR193ADesc(tblDesc));
		this.add(getR194ADesc(tblDesc));
		this.add(getR195ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_pehmapptADesc(tblDesc));
		this.add(getDt_apptADesc(tblDesc));
		this.add(getNo_apptADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_pecmiCDesc(tblDesc));
		tblDesc.add(getId_pecmiCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getA1CDesc(tblDesc));
		tblDesc.add(getA2CDesc(tblDesc));
		tblDesc.add(getA3CDesc(tblDesc));
		tblDesc.add(getA4CDesc(tblDesc));
		tblDesc.add(getA5CDesc(tblDesc));
		tblDesc.add(getA6CDesc(tblDesc));
		tblDesc.add(getA7CDesc(tblDesc));
		tblDesc.add(getA8CDesc(tblDesc));
		tblDesc.add(getA9CDesc(tblDesc));
		tblDesc.add(getB10CDesc(tblDesc));
		tblDesc.add(getB11CDesc(tblDesc));
		tblDesc.add(getB12CDesc(tblDesc));
		tblDesc.add(getB13CDesc(tblDesc));
		tblDesc.add(getB14CDesc(tblDesc));
		tblDesc.add(getB15CDesc(tblDesc));
		tblDesc.add(getB16CDesc(tblDesc));
		tblDesc.add(getB17CDesc(tblDesc));
		tblDesc.add(getB18CDesc(tblDesc));
		tblDesc.add(getB19CDesc(tblDesc));
		tblDesc.add(getB20CDesc(tblDesc));
		tblDesc.add(getB21CDesc(tblDesc));
		tblDesc.add(getB22CDesc(tblDesc));
		tblDesc.add(getB23CDesc(tblDesc));
		tblDesc.add(getB24CDesc(tblDesc));
		tblDesc.add(getB25CDesc(tblDesc));
		tblDesc.add(getB26CDesc(tblDesc));
		tblDesc.add(getB27CDesc(tblDesc));
		tblDesc.add(getC28CDesc(tblDesc));
		tblDesc.add(getC29CDesc(tblDesc));
		tblDesc.add(getC30CDesc(tblDesc));
		tblDesc.add(getC31CDesc(tblDesc));
		tblDesc.add(getC32CDesc(tblDesc));
		tblDesc.add(getC33CDesc(tblDesc));
		tblDesc.add(getC34CDesc(tblDesc));
		tblDesc.add(getC35CDesc(tblDesc));
		tblDesc.add(getC36CDesc(tblDesc));
		tblDesc.add(getC37CDesc(tblDesc));
		tblDesc.add(getC38CDesc(tblDesc));
		tblDesc.add(getC39CDesc(tblDesc));
		tblDesc.add(getC40CDesc(tblDesc));
		tblDesc.add(getD41CDesc(tblDesc));
		tblDesc.add(getD42CDesc(tblDesc));
		tblDesc.add(getD43CDesc(tblDesc));
		tblDesc.add(getD44CDesc(tblDesc));
		tblDesc.add(getD45CDesc(tblDesc));
		tblDesc.add(getD46CDesc(tblDesc));
		tblDesc.add(getD47CDesc(tblDesc));
		tblDesc.add(getD48CDesc(tblDesc));
		tblDesc.add(getD49CDesc(tblDesc));
		tblDesc.add(getD50CDesc(tblDesc));
		tblDesc.add(getD51CDesc(tblDesc));
		tblDesc.add(getD52CDesc(tblDesc));
		tblDesc.add(getD53CDesc(tblDesc));
		tblDesc.add(getD54CDesc(tblDesc));
		tblDesc.add(getD55CDesc(tblDesc));
		tblDesc.add(getD56CDesc(tblDesc));
		tblDesc.add(getD57CDesc(tblDesc));
		tblDesc.add(getD58CDesc(tblDesc));
		tblDesc.add(getD59CDesc(tblDesc));
		tblDesc.add(getD60CDesc(tblDesc));
		tblDesc.add(getD61CDesc(tblDesc));
		tblDesc.add(getD62CDesc(tblDesc));
		tblDesc.add(getD63CDesc(tblDesc));
		tblDesc.add(getE64CDesc(tblDesc));
		tblDesc.add(getE65CDesc(tblDesc));
		tblDesc.add(getE66CDesc(tblDesc));
		tblDesc.add(getE67CDesc(tblDesc));
		tblDesc.add(getE68CDesc(tblDesc));
		tblDesc.add(getE69CDesc(tblDesc));
		tblDesc.add(getE70CDesc(tblDesc));
		tblDesc.add(getE71CDesc(tblDesc));
		tblDesc.add(getF72CDesc(tblDesc));
		tblDesc.add(getF73CDesc(tblDesc));
		tblDesc.add(getF74CDesc(tblDesc));
		tblDesc.add(getF75CDesc(tblDesc));
		tblDesc.add(getF76CDesc(tblDesc));
		tblDesc.add(getF77CDesc(tblDesc));
		tblDesc.add(getF78CDesc(tblDesc));
		tblDesc.add(getG79CDesc(tblDesc));
		tblDesc.add(getG80CDesc(tblDesc));
		tblDesc.add(getG81CDesc(tblDesc));
		tblDesc.add(getG82CDesc(tblDesc));
		tblDesc.add(getG83CDesc(tblDesc));
		tblDesc.add(getG84CDesc(tblDesc));
		tblDesc.add(getG85CDesc(tblDesc));
		tblDesc.add(getG86CDesc(tblDesc));
		tblDesc.add(getG87CDesc(tblDesc));
		tblDesc.add(getG88CDesc(tblDesc));
		tblDesc.add(getG89CDesc(tblDesc));
		tblDesc.add(getG90CDesc(tblDesc));
		tblDesc.add(getG91CDesc(tblDesc));
		tblDesc.add(getG92CDesc(tblDesc));
		tblDesc.add(getG93CDesc(tblDesc));
		tblDesc.add(getG94CDesc(tblDesc));
		tblDesc.add(getG95CDesc(tblDesc));
		tblDesc.add(getG96CDesc(tblDesc));
		tblDesc.add(getH97mCDesc(tblDesc));
		tblDesc.add(getH98mCDesc(tblDesc));
		tblDesc.add(getH99mCDesc(tblDesc));
		tblDesc.add(getH100mCDesc(tblDesc));
		tblDesc.add(getH101mCDesc(tblDesc));
		tblDesc.add(getH102mCDesc(tblDesc));
		tblDesc.add(getH97wCDesc(tblDesc));
		tblDesc.add(getH98wCDesc(tblDesc));
		tblDesc.add(getH99wCDesc(tblDesc));
		tblDesc.add(getH100wCDesc(tblDesc));
		tblDesc.add(getH101wCDesc(tblDesc));
		tblDesc.add(getH102wCDesc(tblDesc));
		tblDesc.add(getH103CDesc(tblDesc));
		tblDesc.add(getH104CDesc(tblDesc));
		tblDesc.add(getH105CDesc(tblDesc));
		tblDesc.add(getH106CDesc(tblDesc));
		tblDesc.add(getH107CDesc(tblDesc));
		tblDesc.add(getI108CDesc(tblDesc));
		tblDesc.add(getI109CDesc(tblDesc));
		tblDesc.add(getI110CDesc(tblDesc));
		tblDesc.add(getI111CDesc(tblDesc));
		tblDesc.add(getI112CDesc(tblDesc));
		tblDesc.add(getI113CDesc(tblDesc));
		tblDesc.add(getI114CDesc(tblDesc));
		tblDesc.add(getJ115CDesc(tblDesc));
		tblDesc.add(getJ116CDesc(tblDesc));
		tblDesc.add(getJ117CDesc(tblDesc));
		tblDesc.add(getJ118CDesc(tblDesc));
		tblDesc.add(getJ119CDesc(tblDesc));
		tblDesc.add(getJ120CDesc(tblDesc));
		tblDesc.add(getJ121CDesc(tblDesc));
		tblDesc.add(getJ122CDesc(tblDesc));
		tblDesc.add(getJ123CDesc(tblDesc));
		tblDesc.add(getK124CDesc(tblDesc));
		tblDesc.add(getK125CDesc(tblDesc));
		tblDesc.add(getK126CDesc(tblDesc));
		tblDesc.add(getK127CDesc(tblDesc));
		tblDesc.add(getK128CDesc(tblDesc));
		tblDesc.add(getK129CDesc(tblDesc));
		tblDesc.add(getK130CDesc(tblDesc));
		tblDesc.add(getK131CDesc(tblDesc));
		tblDesc.add(getK132CDesc(tblDesc));
		tblDesc.add(getK133CDesc(tblDesc));
		tblDesc.add(getK134CDesc(tblDesc));
		tblDesc.add(getK135CDesc(tblDesc));
		tblDesc.add(getK136CDesc(tblDesc));
		tblDesc.add(getK137CDesc(tblDesc));
		tblDesc.add(getK138CDesc(tblDesc));
		tblDesc.add(getL139CDesc(tblDesc));
		tblDesc.add(getL140CDesc(tblDesc));
		tblDesc.add(getL141CDesc(tblDesc));
		tblDesc.add(getL142CDesc(tblDesc));
		tblDesc.add(getL143CDesc(tblDesc));
		tblDesc.add(getL144CDesc(tblDesc));
		tblDesc.add(getM145CDesc(tblDesc));
		tblDesc.add(getM146CDesc(tblDesc));
		tblDesc.add(getM147CDesc(tblDesc));
		tblDesc.add(getM148CDesc(tblDesc));
		tblDesc.add(getM149CDesc(tblDesc));
		tblDesc.add(getM150CDesc(tblDesc));
		tblDesc.add(getM151CDesc(tblDesc));
		tblDesc.add(getM152CDesc(tblDesc));
		tblDesc.add(getM153CDesc(tblDesc));
		tblDesc.add(getM154CDesc(tblDesc));
		tblDesc.add(getM155CDesc(tblDesc));
		tblDesc.add(getM156CDesc(tblDesc));
		tblDesc.add(getN157CDesc(tblDesc));
		tblDesc.add(getN158CDesc(tblDesc));
		tblDesc.add(getN159CDesc(tblDesc));
		tblDesc.add(getN160CDesc(tblDesc));
		tblDesc.add(getN161CDesc(tblDesc));
		tblDesc.add(getN162CDesc(tblDesc));
		tblDesc.add(getO163CDesc(tblDesc));
		tblDesc.add(getO164CDesc(tblDesc));
		tblDesc.add(getO165CDesc(tblDesc));
		tblDesc.add(getO166CDesc(tblDesc));
		tblDesc.add(getO167CDesc(tblDesc));
		tblDesc.add(getO168CDesc(tblDesc));
		tblDesc.add(getO169CDesc(tblDesc));
		tblDesc.add(getO170CDesc(tblDesc));
		tblDesc.add(getO171CDesc(tblDesc));
		tblDesc.add(getP172CDesc(tblDesc));
		tblDesc.add(getP173CDesc(tblDesc));
		tblDesc.add(getP174CDesc(tblDesc));
		tblDesc.add(getP175CDesc(tblDesc));
		tblDesc.add(getP176CDesc(tblDesc));
		tblDesc.add(getP177CDesc(tblDesc));
		tblDesc.add(getQ178CDesc(tblDesc));
		tblDesc.add(getQ179CDesc(tblDesc));
		tblDesc.add(getQ180CDesc(tblDesc));
		tblDesc.add(getQ181CDesc(tblDesc));
		tblDesc.add(getQ182CDesc(tblDesc));
		tblDesc.add(getQ183CDesc(tblDesc));
		tblDesc.add(getQ184CDesc(tblDesc));
		tblDesc.add(getQ185CDesc(tblDesc));
		tblDesc.add(getQ186CDesc(tblDesc));
		tblDesc.add(getR187CDesc(tblDesc));
		tblDesc.add(getR188CDesc(tblDesc));
		tblDesc.add(getR189CDesc(tblDesc));
		tblDesc.add(getR190CDesc(tblDesc));
		tblDesc.add(getR191CDesc(tblDesc));
		tblDesc.add(getR192CDesc(tblDesc));
		tblDesc.add(getR193CDesc(tblDesc));
		tblDesc.add(getR194CDesc(tblDesc));
		tblDesc.add(getR195CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_pehmapptCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检康奈尔医学指数主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecmiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecmi",  getId_pecmiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检康奈尔医学指数主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检个人预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检个人预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检客户ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检客户ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 你读报时需要戴眼镜吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A1",  getA1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你读报时需要戴眼镜吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你看远处时需要戴眼镜吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A2",  getA2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你看远处时需要戴眼镜吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A3",  getA3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有频繁的眨眼和流泪？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A4",  getA4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有频繁的眨眼和流泪？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的眼睛是否经常很疼(或出现看物模糊的现象)？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A5",  getA5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的眼睛是否经常很疼(或出现看物模糊的现象)？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的眼睛是否经常发红或发炎？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A6",  getA6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的眼睛是否经常发红或发炎？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否耳背（听力差）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A7",  getA7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否耳背（听力差）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有过中耳炎、耳朵流脓？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A8",  getA8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有过中耳炎、耳朵流脓？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A9",  getA9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你常常不得不为清嗓子而轻咳吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B10",  getB10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你常常不得不为清嗓子而轻咳吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B11",  getB11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你经常连续打喷嚏吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B12",  getB12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你经常连续打喷嚏吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否觉得鼻子老是堵？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B13",  getB13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否觉得鼻子老是堵？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你经常流鼻涕吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B14",  getB14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你经常流鼻涕吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有时鼻子出血很厉害？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B15",  getB15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否有时鼻子出血很厉害？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常得重感冒（或嗓子痛，扁桃体肿大）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B16",  getB16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常得重感冒（或嗓子痛，扁桃体肿大）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B17",  getB17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你在得感冒时总是必须要卧床（或经常吐痰）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B18",  getB18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你在得感冒时总是必须要卧床（或经常吐痰）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否经常感冒使你一冬天都很难受？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B19",  getB19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否经常感冒使你一冬天都很难受？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B20",  getB20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B21",  getB21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常因咳嗽而感到烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B22",  getB22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常因咳嗽而感到烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有过咳血？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B23",  getB23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有过咳血？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有较重的盗汗（睡时出汗、醒时终止）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B24",  getB24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有较重的盗汗（睡时出汗、醒时终止）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B25",  getB25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否得过结核病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B26",  getB26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否得过结核病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你与得结核病的人在一起住过吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getB27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("B27",  getB27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你与得结核病的人在一起住过吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说过你血压很高吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C28",  getC28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医生说过你血压很高吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说过你血压很低吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C29",  getC29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医生说过你血压很低吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你有胸部或心区疼痛吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C30",  getC30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你有胸部或心区疼痛吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常心动过速（心跳过快）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C31",  getC31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常心动过速（心跳过快）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C32",  getC32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常感到呼吸困难？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C33",  getC33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常感到呼吸困难？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否比别人更容易发生气短（喘不上气）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C34",  getC34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否比别人更容易发生气短（喘不上气）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你既使在坐着的情况下有时也会感到气短吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C35",  getC35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你既使在坐着的情况下有时也会感到气短吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有严重的下肢浮肿？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C36",  getC36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有严重的下肢浮肿？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你即使在热天也因手脚发凉而烦恼吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C37",  getC37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你即使在热天也因手脚发凉而烦恼吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常腿抽筋？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C38",  getC38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常腿抽筋？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说过你心脏有毛病吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C39",  getC39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医生说过你心脏有毛病吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有心脏病人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getC40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("C40",  getC40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有心脏病人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否已脱落了一半以上的牙齿？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D41",  getD41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否已脱落了一半以上的牙齿？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否因牙龈（牙床）出血而烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D42",  getD42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否因牙龈（牙床）出血而烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有经常的牙痛？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D43",  getD43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有经常的牙痛？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否你的舌苔常常很厚？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D44",  getD44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否你的舌苔常常很厚？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是食欲不好（不想吃东西）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D45",  getD45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是食欲不好（不想吃东西）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常吃零食？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D46",  getD46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常吃零食？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否吃东西时总是狼吞虎咽？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D47",  getD47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否吃东西时总是狼吞虎咽？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常胃部不舒服（或有时恶心呕吐）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D48",  getD48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常胃部不舒服（或有时恶心呕吐）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你饭后是否经常有胀满（腹部膨胀）的感觉？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D49",  getD49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你饭后是否经常有胀满（腹部膨胀）的感觉？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你饭后是否经常打饱嗝（或烧心吐酸水）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D50",  getD50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你饭后是否经常打饱嗝（或烧心吐酸水）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常犯胃病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD51ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D51",  getD51CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常犯胃病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有消化不良？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD52ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D52",  getD52CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有消化不良？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否严重胃痛使你常常不得不弯着身子？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD53ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D53",  getD53CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否严重胃痛使你常常不得不弯着身子？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否感到胃部持续不舒服？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD54ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D54",  getD54CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否感到胃部持续不舒服？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中有患胃病的人吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD55ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D55",  getD55CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中有患胃病的人吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD56ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D56",  getD56CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常腹泻（拉肚子）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD57ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D57",  getD57CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常腹泻（拉肚子）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD58ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D58",  getD58CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否因曾有过肠道寄生虫而感到烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD59ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D59",  getD59CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否因曾有过肠道寄生虫而感到烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否常有严重便秘（大便干燥）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD60ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D60",  getD60CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否常有严重便秘（大便干燥）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD61ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D61",  getD61CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否曾患过黄疸（眼、皮肤、尿发黄）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD62ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D62",  getD62CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否曾患过黄疸（眼、皮肤、尿发黄）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否得过严重肝胆疾病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD63ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D63",  getD63CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否得过严重肝胆疾病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有关节肿痛？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE64ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E64",  getE64CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有关节肿痛？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的肌肉和关节经常感到发僵或僵硬吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE65ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E65",  getE65CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的肌肉和关节经常感到发僵或僵硬吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的胳膊或腿是否经常感到严重疼痛？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE66ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E66",  getE66CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的胳膊或腿是否经常感到严重疼痛？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE67ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E67",  getE67CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有人患风湿病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE68ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E68",  getE68CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有人患风湿病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE69ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E69",  getE69CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腰背痛是否达到使你不能持续工作的程度？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE70ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E70",  getE70CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("腰背痛是否达到使你不能持续工作的程度？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getE71ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("E71",  getE71CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF72ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F72",  getF72CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你皮肤上的切口通常不易愈合（长好）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF73ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F73",  getF73CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你皮肤上的切口通常不易愈合（长好）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常脸很红？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF74ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F74",  getF74CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常脸很红？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 即使在冷天你也大量出汗吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF75ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F75",  getF75CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("即使在冷天你也大量出汗吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否严重的皮肤搔痒（发痒）使你感到烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF76ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F76",  getF76CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否严重的皮肤搔痒（发痒）使你感到烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF77ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F77",  getF77CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常因生疖肿（肿包）而感到烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getF78ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F78",  getF78CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常因生疖肿（肿包）而感到烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常由于严重头痛而感到十分难受？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG79ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G79",  getG79CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常由于严重头痛而感到十分难受？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常由于头痛、头发沉而感到生活痛苦？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG80ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G80",  getG80CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常由于头痛、头发沉而感到生活痛苦？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中头痛常见吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG81ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G81",  getG81CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中头痛常见吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有一阵发热、一阵发冷的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG82ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G82",  getG82CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有一阵发热、一阵发冷的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你经常有一阵阵严重头晕的感觉吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG83ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G83",  getG83CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你经常有一阵阵严重头晕的感觉吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常晕倒？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG84ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G84",  getG84CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常晕倒？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否晕倒过两次以上？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG85ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G85",  getG85CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否晕倒过两次以上？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你身体某部分是否有经常麻木或震颤的感觉？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG86ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G86",  getG86CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你身体某部分是否有经常麻木或震颤的感觉？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG87ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G87",  getG87CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有被撞击后失去知觉（什么都不知道了）的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG88ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G88",  getG88CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有被撞击后失去知觉（什么都不知道了）的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG89ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G89",  getG89CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否抽过疯（癫痫发作，也叫抽羊角疯）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG90ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G90",  getG90CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否抽过疯（癫痫发作，也叫抽羊角疯）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中有无癫痫病人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG91ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G91",  getG91CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中有无癫痫病人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有严重的咬指甲的习惯？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG92ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G92",  getG92CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有严重的咬指甲的习惯？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG93ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G93",  getG93CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG94ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G94",  getG94CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否尿床？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG95ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G95",  getG95CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否尿床？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在8--14岁（小学和中学）阶段你是否尿床？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getG96ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("G96",  getG96CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("在8--14岁（小学和中学）阶段你是否尿床？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的生殖器是否有过某种严重毛病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH97mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H97m",  getH97mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的生殖器是否有过某种严重毛病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH98mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H98m",  getH98mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否曾接受过生殖器的治疗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH99mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H99m",  getH99mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否曾接受过生殖器的治疗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说过你有脱肛（直肠脱出肛门以外）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH100mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H100m",  getH100mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医生说过你有脱肛（直肠脱出肛门以外）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有过尿血（无痛性的）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH101mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H101m",  getH101mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有过尿血（无痛性的）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否曾因排尿困难而烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH102mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H102m",  getH102mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否曾因排尿困难而烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常痛经（月经期间及前后小肚子疼）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH97wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H97w",  getH97wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常痛经（月经期间及前后小肚子疼）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否在月经期经常得病或感到虚弱？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH98wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H98w",  getH98wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否在月经期经常得病或感到虚弱？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有月经期卧床（或经期外，有阴道流血）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH99wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H99w",  getH99wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有月经期卧床（或经期外，有阴道流血）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有持续严重的脸部潮红和出汗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH100wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H100w",  getH100wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有持续严重的脸部潮红和出汗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你在月经期是否经常有焦躁情绪？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH101wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H101w",  getH101wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你在月经期是否经常有焦躁情绪？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常因白带（阴道白色粘液）异常而烦恼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH102wADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H102w",  getH102wCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常因白带（阴道白色粘液）异常而烦恼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否每天夜里因小便起床？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH103ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H103",  getH103CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否每天夜里因小便起床？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常白天小便次数频繁？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH104ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H104",  getH104CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常白天小便次数频繁？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否小便时经常有烧灼感（火烧样的疼痛）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH105ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H105",  getH105CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否小便时经常有烧灼感（火烧样的疼痛）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有时有尿失控（不能由意识来控制排尿）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH106ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H106",  getH106CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有时有尿失控（不能由意识来控制排尿）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否医生说过你的肾、膀胱有病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getH107ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("H107",  getH107CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否医生说过你的肾、膀胱有病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常感到一阵一阵很疲劳？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI108ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I108",  getI108CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常感到一阵一阵很疲劳？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否工作使你感到筋疲力竭？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI109ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I109",  getI109CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否工作使你感到筋疲力竭？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常早晨起床后即感到疲倦和筋疲力尽？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI110ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I110",  getI110CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常早晨起床后即感到疲倦和筋疲力尽？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否稍做一点工作就感到累？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI111ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I111",  getI111CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否稍做一点工作就感到累？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常因累而吃不下饭？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI112ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I112",  getI112CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常因累而吃不下饭？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有严重的神经衰弱？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI113ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I113",  getI113CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有严重的神经衰弱？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有患神经衰弱的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getI114ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("I114",  getI114CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有患神经衰弱的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常患病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ115ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J115",  getJ115CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常患病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常由于患病而卧床？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ116ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J116",  getJ116CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常由于患病而卧床？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是健康不良？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ117ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J117",  getJ117CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是健康不良？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否别人认为你体弱多病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ118ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J118",  getJ118CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否别人认为你体弱多病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有患病的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ119ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J119",  getJ119CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有患病的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否曾经因严重的疼痛而不能工作？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ120ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J120",  getJ120CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否曾经因严重的疼痛而不能工作？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是因为担心自己的健康而受不了？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ121ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J121",  getJ121CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是因为担心自己的健康而受不了？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是有病而且不愉快？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ122ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J122",  getJ122CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是有病而且不愉快？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常由于健康不好而感到不幸？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJ123ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("J123",  getJ123CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常由于健康不好而感到不幸？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你得过猩红热吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK124ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K124",  getK124CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你得过猩红热吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你小时候是否得过风湿热、四肢疼痛？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK125ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K125",  getK125CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你小时候是否得过风湿热、四肢疼痛？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你曾患过疟疾吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK126ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K126",  getK126CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你曾患过疟疾吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你由于严重贫血而接受过治疗吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK127ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K127",  getK127CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你由于严重贫血而接受过治疗吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你接受过性病治疗吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK128ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K128",  getK128CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你接受过性病治疗吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有糖尿病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK129ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K129",  getK129CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有糖尿病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否医生曾说过你有甲状腺肿（粗脖子病）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK130ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K130",  getK130CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否医生曾说过你有甲状腺肿（粗脖子病）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否接受过肿瘤或癌的治疗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK131ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K131",  getK131CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否接受过肿瘤或癌的治疗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有什么慢性病（或曾接受过原子辐射）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK132ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K132",  getK132CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有什么慢性病（或曾接受过原子辐射）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否过瘦（体重减轻）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK133ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K133",  getK133CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否过瘦（体重减轻）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否过胖（体重增加）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK134ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K134",  getK134CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否过胖（体重增加）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK135ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K135",  getK135CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否住院做过手术？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK136ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K136",  getK136CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否住院做过手术？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你曾有过严重的外伤吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK137ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K137",  getK137CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你曾有过严重的外伤吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常发生小的事故或外伤？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getK138ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("K138",  getK138CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常发生小的事故或外伤？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL139ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L139",  getL139CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否不能做到每天有规律地放松一下（休息）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL140ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L140",  getL140CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否不能做到每天有规律地放松一下（休息）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否不容易做到每天有规律地锻炼？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL141ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L141",  getL141CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否不容易做到每天有规律地锻炼？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否每天吸20支以上的纸烟？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL142ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L142",  getL142CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否每天吸20支以上的纸烟？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否喝茶或喝咖啡比一般的人要多？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL143ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L143",  getL143CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否喝茶或喝咖啡比一般的人要多？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否每天喝两次以上的白酒？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getL144ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("L144",  getL144CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否每天喝两次以上的白酒？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当你考试或被提问时是否出汗很多或颤抖的很厉害？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM145ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M145",  getM145CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("当你考试或被提问时是否出汗很多或颤抖的很厉害？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接近你的主管上级时是否紧张和发抖？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM146ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M146",  getM146CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("接近你的主管上级时是否紧张和发抖？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当你的上级看着你工作时，你是否不知所措？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM147ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M147",  getM147CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("当你的上级看着你工作时，你是否不知所措？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当必须快速做事情时，你是否有头脑完全混乱的现象？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM148ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M148",  getM148CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("当必须快速做事情时，你是否有头脑完全混乱的现象？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 为了避免出错，你做事必须很慢吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM149ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M149",  getM149CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("为了避免出错，你做事必须很慢吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你经常把指令或意图体会（理解）错吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM150ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M150",  getM150CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你经常把指令或意图体会（理解）错吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否生疏的人或场所使你感到害怕？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM151ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M151",  getM151CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否生疏的人或场所使你感到害怕？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身边没有熟人时你是否因孤单而恐慌？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM152ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M152",  getM152CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身边没有熟人时你是否因孤单而恐慌？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是难以下决心（犹豫不决）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM153ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M153",  getM153CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是难以下决心（犹豫不决）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是希望有人在你身边给你出主意？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM154ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M154",  getM154CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是希望有人在你身边给你出主意？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 别人认为你是一个很笨的人吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM155ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M155",  getM155CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("别人认为你是一个很笨的人吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getM156ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("M156",  getM156CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你在聚会中也感到孤独和悲伤吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN157ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N157",  getN157CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你在聚会中也感到孤独和悲伤吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常感到不愉快和情绪抑郁（情绪低落）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN158ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N158",  getN158CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常感到不愉快和情绪抑郁（情绪低落）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常哭？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN159ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N159",  getN159CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常哭？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是感到凄惨与沮丧（灰心失望）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN160ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N160",  getN160CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是感到凄惨与沮丧（灰心失望）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否你对生活感到完全绝望？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN161ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N161",  getN161CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否你对生活感到完全绝望？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常想死（一死了事）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getN162ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("N162",  getN162CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常想死（一死了事）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常烦恼（愁眉不展）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO163ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O163",  getO163CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常烦恼（愁眉不展）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有愁眉不展的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO164ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O164",  getO164CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有愁眉不展的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否稍遇任何一件小事都使你紧张和疲惫？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO165ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O165",  getO165CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否稍遇任何一件小事都使你紧张和疲惫？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否别人认为你是一个神经质（紧张不安，易激动）的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO166ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O166",  getO166CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否别人认为你是一个神经质（紧张不安，易激动）的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有神经质的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO167ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O167",  getO167CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有神经质的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你曾患过精神崩溃吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO168ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O168",  getO168CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你曾患过精神崩溃吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中曾有过精神崩溃的人吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO169ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O169",  getO169CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中曾有过精神崩溃的人吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你在精神病院看过病吗（因为你精神方面的问题）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO170ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O170",  getO170CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你在精神病院看过病吗（因为你精神方面的问题）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有人到精神病院看过病（因为精神方面的问题）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getO171ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("O171",  getO171CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有人到精神病院看过病（因为精神方面的问题）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常害羞和神经过敏？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP172ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P172",  getP172CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常害羞和神经过敏？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你的家属中是否有害羞和神经过敏的人？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP173ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P173",  getP173CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你的家属中是否有害羞和神经过敏的人？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否你的感情容易受到伤害？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP174ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P174",  getP174CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否你的感情容易受到伤害？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否你在受到批评时总是心烦意乱？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP175ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P175",  getP175CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否你在受到批评时总是心烦意乱？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 别人认为你是爱挑剔的人吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP176ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P176",  getP176CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("别人认为你是爱挑剔的人吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常被人误解？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP177ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P177",  getP177CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常被人误解？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你即使对朋友也必须存戒心吗（不放松警惕）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ178ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q178",  getQ178CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你即使对朋友也必须存戒心吗（不放松警惕）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否总是凭一时冲动做事情？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ179ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q179",  getQ179CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否总是凭一时冲动做事情？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否容易烦恼和激怒？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ180ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q180",  getQ180CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否容易烦恼和激怒？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你若不持续克制自己精神就垮了吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ181ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q181",  getQ181CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你若不持续克制自己精神就垮了吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否一点不快就使你紧张和发脾气？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ182ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q182",  getQ182CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否一点不快就使你紧张和发脾气？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在别人支使你时是否易生气？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ183ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q183",  getQ183CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("在别人支使你时是否易生气？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 别人常使你不快和激怒你吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ184ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q184",  getQ184CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("别人常使你不快和激怒你吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当你不能马上得到你所需要的东西时就发脾气吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ185ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q185",  getQ185CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("当你不能马上得到你所需要的东西时就发脾气吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常大发脾气？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ186ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q186",  getQ186CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常大发脾气？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常发抖和战栗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR187ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R187",  getR187CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常发抖和战栗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常紧张焦急？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR188ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R188",  getR188CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常紧张焦急？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR189ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R189",  getR189CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否不管何时，当别人大声对你时，你都被吓得发抖和发软？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR190ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R190",  getR190CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否不管何时，当别人大声对你时，你都被吓得发抖和发软？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你对夜间突然的动静是否感到恐惧（害怕）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR191ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R191",  getR191CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你对夜间突然的动静是否感到恐惧（害怕）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常因恶梦而惊醒？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR192ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R192",  getR192CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常因恶梦而惊醒？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否头脑中经常反复出现某种恐怖（可怕的）想法？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR193ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R193",  getR193CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否头脑中经常反复出现某种恐怖（可怕的）想法？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否常常毫无理由地突然感到畏惧（害怕）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR194ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R194",  getR194CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否常常毫无理由地突然感到畏惧（害怕）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 你是否经常有突然出冷汗的情况？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getR195ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("R195",  getR195CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("你是否经常有突然出冷汗的情况？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmappt",  getId_pehmapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预约日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_appt",  getDt_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("预约日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b8","id_pehmappt=id_pehmappt","dt_appt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_appt",  getNo_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预约号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b8","id_pehmappt=id_pehmappt","no_appt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检康奈尔医学指数主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecmiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecmi");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检康奈尔医学指数主键标识"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取体检个人预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检个人预约单ID"); 
		return column;
	}
	/**
	 * 获取体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户ID"); 
		return column;
	}
	/**
	 * 获取你读报时需要戴眼镜吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A1");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你读报时需要戴眼镜吗？"); 
		return column;
	}
	/**
	 * 获取你看远处时需要戴眼镜吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A2");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你看远处时需要戴眼镜吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A3");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有一时性的眼前发黑（视力下降或看不见东西）的现象？"); 
		return column;
	}
	/**
	 * 获取你是否有频繁的眨眼和流泪？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A4");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有频繁的眨眼和流泪？"); 
		return column;
	}
	/**
	 * 获取你的眼睛是否经常很疼(或出现看物模糊的现象)？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A5");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的眼睛是否经常很疼(或出现看物模糊的现象)？"); 
		return column;
	}
	/**
	 * 获取你的眼睛是否经常发红或发炎？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A6");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的眼睛是否经常发红或发炎？"); 
		return column;
	}
	/**
	 * 获取你是否耳背（听力差）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A7");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否耳背（听力差）？"); 
		return column;
	}
	/**
	 * 获取你是否有过中耳炎、耳朵流脓？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A8");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有过中耳炎、耳朵流脓？"); 
		return column;
	}
	/**
	 * 获取你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A9");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常耳鸣？（耳中自觉有各种声响，以致影响听觉）"); 
		return column;
	}
	/**
	 * 获取你常常不得不为清嗓子而轻咳吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B10");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你常常不得不为清嗓子而轻咳吗？"); 
		return column;
	}
	/**
	 * 获取你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B11");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你经常有嗓子发堵的感觉（感觉喉咙里有东西）吗？"); 
		return column;
	}
	/**
	 * 获取你经常连续打喷嚏吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B12");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你经常连续打喷嚏吗？"); 
		return column;
	}
	/**
	 * 获取你是否觉得鼻子老是堵？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B13");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否觉得鼻子老是堵？"); 
		return column;
	}
	/**
	 * 获取你经常流鼻涕吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B14");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你经常流鼻涕吗？"); 
		return column;
	}
	/**
	 * 获取是否有时鼻子出血很厉害？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B15");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否有时鼻子出血很厉害？"); 
		return column;
	}
	/**
	 * 获取你是否经常得重感冒（或嗓子痛，扁桃体肿大）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B16");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常得重感冒（或嗓子痛，扁桃体肿大）？"); 
		return column;
	}
	/**
	 * 获取你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B17");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有严重的慢性支气管炎（在感冒时咳嗽，吐痰拖很长时间）？"); 
		return column;
	}
	/**
	 * 获取你在得感冒时总是必须要卧床（或经常吐痰）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B18");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你在得感冒时总是必须要卧床（或经常吐痰）吗？"); 
		return column;
	}
	/**
	 * 获取是否经常感冒使你一冬天都很难受？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B19");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否经常感冒使你一冬天都很难受？"); 
		return column;
	}
	/**
	 * 获取你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B20");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有过敏型哮喘？（以某些过敏因素，如花粉等为诱因的哮喘）"); 
		return column;
	}
	/**
	 * 获取你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B21");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有哮喘（反复发作的，暂时性的伴有喘音的呼吸困难）"); 
		return column;
	}
	/**
	 * 获取你是否经常因咳嗽而感到烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B22");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常因咳嗽而感到烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否有过咳血？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B23");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有过咳血？"); 
		return column;
	}
	/**
	 * 获取你是否有较重的盗汗（睡时出汗、醒时终止）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B24");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有较重的盗汗（睡时出汗、醒时终止）？"); 
		return column;
	}
	/**
	 * 获取你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B25");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你除结核外是否患过慢性呼吸道疾病（或有低烧（热）37-38度）？"); 
		return column;
	}
	/**
	 * 获取你是否得过结核病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B26");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否得过结核病？"); 
		return column;
	}
	/**
	 * 获取你与得结核病的人在一起住过吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getB27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"B27");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你与得结核病的人在一起住过吗？"); 
		return column;
	}
	/**
	 * 获取医生说过你血压很高吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C28");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医生说过你血压很高吗？"); 
		return column;
	}
	/**
	 * 获取医生说过你血压很低吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C29");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医生说过你血压很低吗？"); 
		return column;
	}
	/**
	 * 获取你有胸部或心区疼痛吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C30");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你有胸部或心区疼痛吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常心动过速（心跳过快）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C31");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常心动过速（心跳过快）吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C32");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常心悸（平静时有心脏跳动的感觉）或（感到脉搏有停跳）？"); 
		return column;
	}
	/**
	 * 获取你是否经常感到呼吸困难？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C33");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常感到呼吸困难？"); 
		return column;
	}
	/**
	 * 获取你是否比别人更容易发生气短（喘不上气）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C34");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否比别人更容易发生气短（喘不上气）？"); 
		return column;
	}
	/**
	 * 获取你既使在坐着的情况下有时也会感到气短吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C35");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你既使在坐着的情况下有时也会感到气短吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常有严重的下肢浮肿？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C36");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有严重的下肢浮肿？"); 
		return column;
	}
	/**
	 * 获取你即使在热天也因手脚发凉而烦恼吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C37");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你即使在热天也因手脚发凉而烦恼吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常腿抽筋？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C38");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常腿抽筋？"); 
		return column;
	}
	/**
	 * 获取医生说过你心脏有毛病吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C39");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医生说过你心脏有毛病吗？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有心脏病人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getC40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"C40");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有心脏病人？"); 
		return column;
	}
	/**
	 * 获取你是否已脱落了一半以上的牙齿？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D41");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否已脱落了一半以上的牙齿？"); 
		return column;
	}
	/**
	 * 获取你是否因牙龈（牙床）出血而烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D42");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否因牙龈（牙床）出血而烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否有经常的牙痛？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D43");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有经常的牙痛？"); 
		return column;
	}
	/**
	 * 获取是否你的舌苔常常很厚？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D44");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否你的舌苔常常很厚？"); 
		return column;
	}
	/**
	 * 获取你是否总是食欲不好（不想吃东西）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D45");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是食欲不好（不想吃东西）？"); 
		return column;
	}
	/**
	 * 获取你是否经常吃零食？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D46");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常吃零食？"); 
		return column;
	}
	/**
	 * 获取你是否吃东西时总是狼吞虎咽？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D47");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否吃东西时总是狼吞虎咽？"); 
		return column;
	}
	/**
	 * 获取你是否经常胃部不舒服（或有时恶心呕吐）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D48");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常胃部不舒服（或有时恶心呕吐）？"); 
		return column;
	}
	/**
	 * 获取你饭后是否经常有胀满（腹部膨胀）的感觉？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D49");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你饭后是否经常有胀满（腹部膨胀）的感觉？"); 
		return column;
	}
	/**
	 * 获取你饭后是否经常打饱嗝（或烧心吐酸水）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D50");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你饭后是否经常打饱嗝（或烧心吐酸水）？"); 
		return column;
	}
	/**
	 * 获取你是否经常犯胃病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD51CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D51");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常犯胃病？"); 
		return column;
	}
	/**
	 * 获取你是否有消化不良？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD52CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D52");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有消化不良？"); 
		return column;
	}
	/**
	 * 获取是否严重胃痛使你常常不得不弯着身子？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD53CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D53");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否严重胃痛使你常常不得不弯着身子？"); 
		return column;
	}
	/**
	 * 获取你是否感到胃部持续不舒服？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD54CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D54");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否感到胃部持续不舒服？"); 
		return column;
	}
	/**
	 * 获取你的家属中有患胃病的人吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD55CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D55");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中有患胃病的人吗？"); 
		return column;
	}
	/**
	 * 获取医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD56CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D56");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医生说过你有胃或十二指肠溃疡病（或饭后、空腹时常感到胃痛）？"); 
		return column;
	}
	/**
	 * 获取你是否经常腹泻（拉肚子）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD57CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D57");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常腹泻（拉肚子）？"); 
		return column;
	}
	/**
	 * 获取你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD58CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D58");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你腹泻时是否有严重血便或粘液（粪便发黑、有血液或沾稠物质）？"); 
		return column;
	}
	/**
	 * 获取你是否因曾有过肠道寄生虫而感到烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD59CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D59");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否因曾有过肠道寄生虫而感到烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否常有严重便秘（大便干燥）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD60CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D60");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否常有严重便秘（大便干燥）？"); 
		return column;
	}
	/**
	 * 获取你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD61CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D61");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有痔疮（大便时肛门疼痛不适，大便表面带血或便后滴血）？"); 
		return column;
	}
	/**
	 * 获取你是否曾患过黄疸（眼、皮肤、尿发黄）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD62CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D62");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否曾患过黄疸（眼、皮肤、尿发黄）？"); 
		return column;
	}
	/**
	 * 获取你是否得过严重肝胆疾病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD63CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D63");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否得过严重肝胆疾病？"); 
		return column;
	}
	/**
	 * 获取你是否经常有关节肿痛？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE64CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E64");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有关节肿痛？"); 
		return column;
	}
	/**
	 * 获取你的肌肉和关节经常感到发僵或僵硬吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE65CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E65");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的肌肉和关节经常感到发僵或僵硬吗？"); 
		return column;
	}
	/**
	 * 获取你的胳膊或腿是否经常感到严重疼痛？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE66CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E66");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的胳膊或腿是否经常感到严重疼痛？"); 
		return column;
	}
	/**
	 * 获取严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE67CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E67");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("严重的风湿病使你丧失活动能力（或有肩、脖子肌肉发紧的现象）？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有人患风湿病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE68CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E68");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有人患风湿病？"); 
		return column;
	}
	/**
	 * 获取脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE69CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E69");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脚发软、疼痛使你的生活严重不便（或经常感到腿、脚发酸）？"); 
		return column;
	}
	/**
	 * 获取腰背痛是否达到使你不能持续工作的程度？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE70CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E70");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("腰背痛是否达到使你不能持续工作的程度？"); 
		return column;
	}
	/**
	 * 获取你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getE71CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"E71");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否因身体有严重的功能丧失或畸形（形态异常）而感到烦恼？"); 
		return column;
	}
	/**
	 * 获取你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF72CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F72");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的皮肤对温度、疼痛十分敏感，有压痛（或有皮下小出血点）？"); 
		return column;
	}
	/**
	 * 获取你皮肤上的切口通常不易愈合（长好）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF73CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F73");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你皮肤上的切口通常不易愈合（长好）吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常脸很红？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF74CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F74");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常脸很红？"); 
		return column;
	}
	/**
	 * 获取即使在冷天你也大量出汗吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF75CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F75");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("即使在冷天你也大量出汗吗？"); 
		return column;
	}
	/**
	 * 获取是否严重的皮肤搔痒（发痒）使你感到烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF76CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F76");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否严重的皮肤搔痒（发痒）使你感到烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF77CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F77");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常出皮疹（风疙瘩或疹子）或（有时脸部浮肿）？"); 
		return column;
	}
	/**
	 * 获取你是否经常因生疖肿（肿包）而感到烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getF78CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F78");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常因生疖肿（肿包）而感到烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否经常由于严重头痛而感到十分难受？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG79CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G79");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常由于严重头痛而感到十分难受？"); 
		return column;
	}
	/**
	 * 获取你是否经常由于头痛、头发沉而感到生活痛苦？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG80CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G80");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常由于头痛、头发沉而感到生活痛苦？"); 
		return column;
	}
	/**
	 * 获取你的家属中头痛常见吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG81CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G81");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中头痛常见吗？"); 
		return column;
	}
	/**
	 * 获取你是否有一阵发热、一阵发冷的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG82CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G82");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有一阵发热、一阵发冷的现象？"); 
		return column;
	}
	/**
	 * 获取你经常有一阵阵严重头晕的感觉吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG83CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G83");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你经常有一阵阵严重头晕的感觉吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常晕倒？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG84CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G84");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常晕倒？"); 
		return column;
	}
	/**
	 * 获取你是否晕倒过两次以上？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG85CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G85");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否晕倒过两次以上？"); 
		return column;
	}
	/**
	 * 获取你身体某部分是否有经常麻木或震颤的感觉？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG86CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G86");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你身体某部分是否有经常麻木或震颤的感觉？"); 
		return column;
	}
	/**
	 * 获取你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG87CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G87");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你身体某部分曾经瘫痪（感觉和运动能力完全或部分丧失）过吗？"); 
		return column;
	}
	/**
	 * 获取你是否有被撞击后失去知觉（什么都不知道了）的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG88CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G88");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有被撞击后失去知觉（什么都不知道了）的现象？"); 
		return column;
	}
	/**
	 * 获取你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG89CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G89");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你头、面、肩部是否有时有抽搐（突然而迅速的肌肉抽动）的感觉？"); 
		return column;
	}
	/**
	 * 获取你是否抽过疯（癫痫发作，也叫抽羊角疯）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG90CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G90");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否抽过疯（癫痫发作，也叫抽羊角疯）？"); 
		return column;
	}
	/**
	 * 获取你的家属中有无癫痫病人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG91CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G91");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中有无癫痫病人？"); 
		return column;
	}
	/**
	 * 获取你是否有严重的咬指甲的习惯？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG92CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G92");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有严重的咬指甲的习惯？"); 
		return column;
	}
	/**
	 * 获取你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG93CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G93");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否因说话结巴或口吃而烦恼（或因舌头不灵活而导致说话困难）？"); 
		return column;
	}
	/**
	 * 获取你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG94CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G94");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有梦游症（睡眠时走来走去，事后不能回忆所做的事情）？"); 
		return column;
	}
	/**
	 * 获取你是否尿床？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG95CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G95");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否尿床？"); 
		return column;
	}
	/**
	 * 获取在8--14岁（小学和中学）阶段你是否尿床？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getG96CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"G96");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("在8--14岁（小学和中学）阶段你是否尿床？"); 
		return column;
	}
	/**
	 * 获取你的生殖器是否有过某种严重毛病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH97mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H97m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的生殖器是否有过某种严重毛病？"); 
		return column;
	}
	/**
	 * 获取你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH98mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H98m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有生殖器疼痛或触痛（一碰就痛）的现象？"); 
		return column;
	}
	/**
	 * 获取你是否曾接受过生殖器的治疗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH99mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H99m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否曾接受过生殖器的治疗？"); 
		return column;
	}
	/**
	 * 获取医生说过你有脱肛（直肠脱出肛门以外）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH100mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H100m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医生说过你有脱肛（直肠脱出肛门以外）吗？"); 
		return column;
	}
	/**
	 * 获取你是否有过尿血（无痛性的）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH101mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H101m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有过尿血（无痛性的）？"); 
		return column;
	}
	/**
	 * 获取你是否曾因排尿困难而烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH102mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H102m");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否曾因排尿困难而烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否经常痛经（月经期间及前后小肚子疼）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH97wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H97w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常痛经（月经期间及前后小肚子疼）？"); 
		return column;
	}
	/**
	 * 获取你是否在月经期经常得病或感到虚弱？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH98wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H98w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否在月经期经常得病或感到虚弱？"); 
		return column;
	}
	/**
	 * 获取你是否经常有月经期卧床（或经期外，有阴道流血）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH99wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H99w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有月经期卧床（或经期外，有阴道流血）？"); 
		return column;
	}
	/**
	 * 获取你是否经常有持续严重的脸部潮红和出汗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH100wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H100w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有持续严重的脸部潮红和出汗？"); 
		return column;
	}
	/**
	 * 获取你在月经期是否经常有焦躁情绪？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH101wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H101w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你在月经期是否经常有焦躁情绪？"); 
		return column;
	}
	/**
	 * 获取你是否经常因白带（阴道白色粘液）异常而烦恼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH102wCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H102w");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常因白带（阴道白色粘液）异常而烦恼？"); 
		return column;
	}
	/**
	 * 获取你是否每天夜里因小便起床？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH103CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H103");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否每天夜里因小便起床？"); 
		return column;
	}
	/**
	 * 获取你是否经常白天小便次数频繁？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH104CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H104");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常白天小便次数频繁？"); 
		return column;
	}
	/**
	 * 获取你是否小便时经常有烧灼感（火烧样的疼痛）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH105CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H105");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否小便时经常有烧灼感（火烧样的疼痛）？"); 
		return column;
	}
	/**
	 * 获取你是否有时有尿失控（不能由意识来控制排尿）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH106CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H106");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有时有尿失控（不能由意识来控制排尿）？"); 
		return column;
	}
	/**
	 * 获取是否医生说过你的肾、膀胱有病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getH107CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"H107");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否医生说过你的肾、膀胱有病？"); 
		return column;
	}
	/**
	 * 获取你是否经常感到一阵一阵很疲劳？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI108CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I108");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常感到一阵一阵很疲劳？"); 
		return column;
	}
	/**
	 * 获取是否工作使你感到筋疲力竭？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI109CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I109");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否工作使你感到筋疲力竭？"); 
		return column;
	}
	/**
	 * 获取你是否经常早晨起床后即感到疲倦和筋疲力尽？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI110CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I110");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常早晨起床后即感到疲倦和筋疲力尽？"); 
		return column;
	}
	/**
	 * 获取你是否稍做一点工作就感到累？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI111CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I111");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否稍做一点工作就感到累？"); 
		return column;
	}
	/**
	 * 获取你是否经常因累而吃不下饭？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI112CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I112");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常因累而吃不下饭？"); 
		return column;
	}
	/**
	 * 获取你是否有严重的神经衰弱？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI113CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I113");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有严重的神经衰弱？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有患神经衰弱的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getI114CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"I114");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有患神经衰弱的人？"); 
		return column;
	}
	/**
	 * 获取你是否经常患病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ115CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J115");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常患病？"); 
		return column;
	}
	/**
	 * 获取你是否经常由于患病而卧床？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ116CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J116");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常由于患病而卧床？"); 
		return column;
	}
	/**
	 * 获取你是否总是健康不良？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ117CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J117");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是健康不良？"); 
		return column;
	}
	/**
	 * 获取是否别人认为你体弱多病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ118CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J118");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否别人认为你体弱多病？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有患病的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ119CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J119");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有患病的人？"); 
		return column;
	}
	/**
	 * 获取你是否曾经因严重的疼痛而不能工作？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ120CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J120");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否曾经因严重的疼痛而不能工作？"); 
		return column;
	}
	/**
	 * 获取你是否总是因为担心自己的健康而受不了？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ121CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J121");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是因为担心自己的健康而受不了？"); 
		return column;
	}
	/**
	 * 获取你是否总是有病而且不愉快？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ122CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J122");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是有病而且不愉快？"); 
		return column;
	}
	/**
	 * 获取你是否经常由于健康不好而感到不幸？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJ123CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"J123");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常由于健康不好而感到不幸？"); 
		return column;
	}
	/**
	 * 获取你得过猩红热吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK124CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K124");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你得过猩红热吗？"); 
		return column;
	}
	/**
	 * 获取你小时候是否得过风湿热、四肢疼痛？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK125CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K125");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你小时候是否得过风湿热、四肢疼痛？"); 
		return column;
	}
	/**
	 * 获取你曾患过疟疾吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK126CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K126");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你曾患过疟疾吗？"); 
		return column;
	}
	/**
	 * 获取你由于严重贫血而接受过治疗吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK127CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K127");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你由于严重贫血而接受过治疗吗？"); 
		return column;
	}
	/**
	 * 获取你接受过性病治疗吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK128CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K128");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你接受过性病治疗吗？"); 
		return column;
	}
	/**
	 * 获取你是否有糖尿病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK129CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K129");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有糖尿病？"); 
		return column;
	}
	/**
	 * 获取是否医生曾说过你有甲状腺肿（粗脖子病）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK130CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K130");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否医生曾说过你有甲状腺肿（粗脖子病）？"); 
		return column;
	}
	/**
	 * 获取你是否接受过肿瘤或癌的治疗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK131CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K131");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否接受过肿瘤或癌的治疗？"); 
		return column;
	}
	/**
	 * 获取你是否有什么慢性病（或曾接受过原子辐射）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK132CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K132");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有什么慢性病（或曾接受过原子辐射）？"); 
		return column;
	}
	/**
	 * 获取你是否过瘦（体重减轻）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK133CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K133");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否过瘦（体重减轻）？"); 
		return column;
	}
	/**
	 * 获取你是否过胖（体重增加）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK134CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K134");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否过胖（体重增加）？"); 
		return column;
	}
	/**
	 * 获取是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK135CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K135");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否有医生说过你有腿部静脉曲张（腿部青筋暴露）？"); 
		return column;
	}
	/**
	 * 获取你是否住院做过手术？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK136CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K136");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否住院做过手术？"); 
		return column;
	}
	/**
	 * 获取你曾有过严重的外伤吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK137CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K137");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你曾有过严重的外伤吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常发生小的事故或外伤？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getK138CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"K138");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常发生小的事故或外伤？"); 
		return column;
	}
	/**
	 * 获取你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL139CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L139");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否有入睡很困难或睡眠不深易醒（或经常做梦）的现象？"); 
		return column;
	}
	/**
	 * 获取你是否不能做到每天有规律地放松一下（休息）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL140CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L140");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否不能做到每天有规律地放松一下（休息）？"); 
		return column;
	}
	/**
	 * 获取你是否不容易做到每天有规律地锻炼？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL141CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L141");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否不容易做到每天有规律地锻炼？"); 
		return column;
	}
	/**
	 * 获取你是否每天吸20支以上的纸烟？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL142CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L142");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否每天吸20支以上的纸烟？"); 
		return column;
	}
	/**
	 * 获取你是否喝茶或喝咖啡比一般的人要多？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL143CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L143");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否喝茶或喝咖啡比一般的人要多？"); 
		return column;
	}
	/**
	 * 获取你是否每天喝两次以上的白酒？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getL144CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"L144");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否每天喝两次以上的白酒？"); 
		return column;
	}
	/**
	 * 获取当你考试或被提问时是否出汗很多或颤抖的很厉害？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM145CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M145");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("当你考试或被提问时是否出汗很多或颤抖的很厉害？"); 
		return column;
	}
	/**
	 * 获取接近你的主管上级时是否紧张和发抖？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM146CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M146");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("接近你的主管上级时是否紧张和发抖？"); 
		return column;
	}
	/**
	 * 获取当你的上级看着你工作时，你是否不知所措？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM147CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M147");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("当你的上级看着你工作时，你是否不知所措？"); 
		return column;
	}
	/**
	 * 获取当必须快速做事情时，你是否有头脑完全混乱的现象？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM148CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M148");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("当必须快速做事情时，你是否有头脑完全混乱的现象？"); 
		return column;
	}
	/**
	 * 获取为了避免出错，你做事必须很慢吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM149CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M149");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("为了避免出错，你做事必须很慢吗？"); 
		return column;
	}
	/**
	 * 获取你经常把指令或意图体会（理解）错吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM150CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M150");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你经常把指令或意图体会（理解）错吗？"); 
		return column;
	}
	/**
	 * 获取是否生疏的人或场所使你感到害怕？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM151CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M151");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否生疏的人或场所使你感到害怕？"); 
		return column;
	}
	/**
	 * 获取身边没有熟人时你是否因孤单而恐慌？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM152CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M152");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身边没有熟人时你是否因孤单而恐慌？"); 
		return column;
	}
	/**
	 * 获取你是否总是难以下决心（犹豫不决）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM153CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M153");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是难以下决心（犹豫不决）？"); 
		return column;
	}
	/**
	 * 获取你是否总是希望有人在你身边给你出主意？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM154CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M154");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是希望有人在你身边给你出主意？"); 
		return column;
	}
	/**
	 * 获取别人认为你是一个很笨的人吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM155CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M155");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("别人认为你是一个很笨的人吗？"); 
		return column;
	}
	/**
	 * 获取除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getM156CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"M156");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("除了在你自己家以外，在其它任何地方吃东西都感到烦扰吗？"); 
		return column;
	}
	/**
	 * 获取你在聚会中也感到孤独和悲伤吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN157CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N157");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你在聚会中也感到孤独和悲伤吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常感到不愉快和情绪抑郁（情绪低落）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN158CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N158");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常感到不愉快和情绪抑郁（情绪低落）？"); 
		return column;
	}
	/**
	 * 获取你是否经常哭？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN159CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N159");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常哭？"); 
		return column;
	}
	/**
	 * 获取你是否总是感到凄惨与沮丧（灰心失望）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN160CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N160");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是感到凄惨与沮丧（灰心失望）？"); 
		return column;
	}
	/**
	 * 获取是否你对生活感到完全绝望？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN161CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N161");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否你对生活感到完全绝望？"); 
		return column;
	}
	/**
	 * 获取你是否经常想死（一死了事）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getN162CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"N162");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常想死（一死了事）？"); 
		return column;
	}
	/**
	 * 获取你是否经常烦恼（愁眉不展）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO163CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O163");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常烦恼（愁眉不展）？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有愁眉不展的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO164CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O164");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有愁眉不展的人？"); 
		return column;
	}
	/**
	 * 获取是否稍遇任何一件小事都使你紧张和疲惫？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO165CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O165");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否稍遇任何一件小事都使你紧张和疲惫？"); 
		return column;
	}
	/**
	 * 获取是否别人认为你是一个神经质（紧张不安，易激动）的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO166CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O166");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否别人认为你是一个神经质（紧张不安，易激动）的人？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有神经质的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO167CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O167");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有神经质的人？"); 
		return column;
	}
	/**
	 * 获取你曾患过精神崩溃吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO168CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O168");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你曾患过精神崩溃吗？"); 
		return column;
	}
	/**
	 * 获取你的家属中曾有过精神崩溃的人吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO169CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O169");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中曾有过精神崩溃的人吗？"); 
		return column;
	}
	/**
	 * 获取你在精神病院看过病吗（因为你精神方面的问题）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO170CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O170");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你在精神病院看过病吗（因为你精神方面的问题）？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有人到精神病院看过病（因为精神方面的问题）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getO171CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"O171");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有人到精神病院看过病（因为精神方面的问题）？"); 
		return column;
	}
	/**
	 * 获取你是否经常害羞和神经过敏？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP172CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P172");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常害羞和神经过敏？"); 
		return column;
	}
	/**
	 * 获取你的家属中是否有害羞和神经过敏的人？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP173CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P173");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你的家属中是否有害羞和神经过敏的人？"); 
		return column;
	}
	/**
	 * 获取是否你的感情容易受到伤害？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP174CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P174");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否你的感情容易受到伤害？"); 
		return column;
	}
	/**
	 * 获取是否你在受到批评时总是心烦意乱？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP175CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P175");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否你在受到批评时总是心烦意乱？"); 
		return column;
	}
	/**
	 * 获取别人认为你是爱挑剔的人吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP176CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P176");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("别人认为你是爱挑剔的人吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常被人误解？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP177CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P177");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常被人误解？"); 
		return column;
	}
	/**
	 * 获取你即使对朋友也必须存戒心吗（不放松警惕）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ178CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q178");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你即使对朋友也必须存戒心吗（不放松警惕）？"); 
		return column;
	}
	/**
	 * 获取你是否总是凭一时冲动做事情？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ179CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q179");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否总是凭一时冲动做事情？"); 
		return column;
	}
	/**
	 * 获取你是否容易烦恼和激怒？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ180CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q180");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否容易烦恼和激怒？"); 
		return column;
	}
	/**
	 * 获取你若不持续克制自己精神就垮了吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ181CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q181");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你若不持续克制自己精神就垮了吗？"); 
		return column;
	}
	/**
	 * 获取是否一点不快就使你紧张和发脾气？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ182CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q182");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否一点不快就使你紧张和发脾气？"); 
		return column;
	}
	/**
	 * 获取在别人支使你时是否易生气？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ183CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q183");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("在别人支使你时是否易生气？"); 
		return column;
	}
	/**
	 * 获取别人常使你不快和激怒你吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ184CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q184");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("别人常使你不快和激怒你吗？"); 
		return column;
	}
	/**
	 * 获取当你不能马上得到你所需要的东西时就发脾气吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ185CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q185");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("当你不能马上得到你所需要的东西时就发脾气吗？"); 
		return column;
	}
	/**
	 * 获取你是否经常大发脾气？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ186CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q186");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常大发脾气？"); 
		return column;
	}
	/**
	 * 获取你是否经常发抖和战栗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR187CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R187");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常发抖和战栗？"); 
		return column;
	}
	/**
	 * 获取你是否经常紧张焦急？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR188CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R188");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常紧张焦急？"); 
		return column;
	}
	/**
	 * 获取你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR189CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R189");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否会被突然的声音吓一大跳（跳起或发抖得厉害）？"); 
		return column;
	}
	/**
	 * 获取是否不管何时，当别人大声对你时，你都被吓得发抖和发软？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR190CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R190");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否不管何时，当别人大声对你时，你都被吓得发抖和发软？"); 
		return column;
	}
	/**
	 * 获取你对夜间突然的动静是否感到恐惧（害怕）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR191CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R191");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你对夜间突然的动静是否感到恐惧（害怕）？"); 
		return column;
	}
	/**
	 * 获取你是否经常因恶梦而惊醒？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR192CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R192");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常因恶梦而惊醒？"); 
		return column;
	}
	/**
	 * 获取你是否头脑中经常反复出现某种恐怖（可怕的）想法？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR193CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R193");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否头脑中经常反复出现某种恐怖（可怕的）想法？"); 
		return column;
	}
	/**
	 * 获取你是否常常毫无理由地突然感到畏惧（害怕）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR194CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R194");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否常常毫无理由地突然感到畏惧（害怕）？"); 
		return column;
	}
	/**
	 * 获取你是否经常有突然出冷汗的情况？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getR195CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"R195");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("你是否经常有突然出冷汗的情况？"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取健康预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康预约单ID"); 
		return column;
	}
	/**
	 * 获取预约日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_appt");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约日期"); 
		return column;
	}
	/**
	 * 获取预约号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_appt");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预约号"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pecmi");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
