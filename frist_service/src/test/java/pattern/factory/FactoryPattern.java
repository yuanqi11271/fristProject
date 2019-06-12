package pattern.factory;

import com.yuanqi.service.practice.factory.abstractF.AbstraFactory;
import com.yuanqi.service.practice.factory.abstractF.FactoryProducer;
import com.yuanqi.service.practice.factory.abstractF.SpeedFactory;
import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;
import com.yuanqi.service.practice.factory.factory.EatFactory;
import com.yuanqi.service.practice.factory.factory.interfac.EatInterface;
import org.junit.Test;

/**
 * @Author: yq
 * @Date：2019/6/6 15:17
 * @Describe:
 */
public class FactoryPattern {

    /**
     * 简单工厂
     * @param
     */
    @Test
    public void factoryTest (){
        EatInterface cat = EatFactory.getEat("cat");
        cat.eat();
        EatInterface god = EatFactory.getEat("god");
        god.eat();
    }

    /**
     * 抽象工厂
     */
    @Test
    public void AbstractFactoryTest (){
        AbstraFactory color = FactoryProducer.getFactory("color");
        ColorInterface dog = color.getColor("dog");
        dog.color();

        FactoryProducer.getFactory("speed").getSpeed("cat")
                .speed();

    }
}
