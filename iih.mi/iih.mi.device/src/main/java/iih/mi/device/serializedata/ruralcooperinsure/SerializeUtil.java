package iih.mi.device.serializedata.ruralcooperinsure;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class SerializeUtil{
    public static <T extends BaseDTO> T deserialize(T obj,Element node, String[] attrArray) throws BizException, InstantiationException, IllegalAccessException {
//        T dto = obj.newInstance();
        List<Element> nodeList = node.elements();
        if(nodeList.size()!=attrArray.length)
            throw new BizException("在返回webservice的xml转化为数据源时不匹配，属性值个数不符合");
        int i = 0;
        for (Node item : nodeList){
        	obj.setAttrVal(attrArray[i],item.getText());
            i++;
        }
        return obj;
    }
}
