package allProject.dao.impl;

import allProject.dao.HobbyDao;
import allProject.entity.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */
@Repository
public class HobbyDaoImpl implements HobbyDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().saveOrUpdate(hobby);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Set<Hobby> getAllHobbies() {
        List<Hobby> hobbyList = sessionFactory.getCurrentSession().createQuery("from Hobby").list();
        Set<Hobby> hobbySet = new HashSet<Hobby>();
        if (hobbyList == null)return null;
        for (Hobby hobby : hobbyList){
            hobbySet.add(hobby);
        }
        return hobbySet;
    }

    @Override
    @Transactional
    public void deleteHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().delete(hobby);
    }



    /**
     * @SuppressWarnings. Полезность этой аннотации в том, что она общепринята к использованию во всех IDE (Integrated
     * Development Environment, такие как Eclipse, NetBeans или IntelliJ IDEA) и позволяет скрывать предупреждения
     * компиляторов.
     * Классы предупреждений
     * Существуют не только предупреждения о неявных присваиваниях - видов предупреждений гораздо больше, чем один.
     * В следующем списке указаны самые распространенные классы ошибок:
     * all - игнорировать все предупреждения;
    * boxing - игнорировать предупреждения, связанные с боксингом (оборачиванием примитивных типов (int, double, short и т.п.) в объектные типы (Integer, Double, Short и т.п.);
    cast - игнорировать предупреждения приведения типов;
    dep-ann - игнорировать предупреждения, связанные с использованием deprecated-аннотаций (аннотации подготовленные к удалению из библиотеки);
    deprecation - игнорировать использование deprecated-элементов (методы и поля подготовленные к удалению из библиотеки);
    fallthrough - игнорировать пропущенные операторы break в switch-блоках;
    finally - игнорировать finally-блоки, которые не используют return;
    hiding - игнорировать предупреждения о том, что локальная переменная скрывает другую переменную;
    incomplete-switch - игнорировать предупреждения о незавершенных switch-блоках (например, когда в таком блоке использованы не все элементы перечисления);
    nls - игнорировать предупреждения при обнаружении непереводимых символов (NLS String Literals);
    null - игнорировать предупреждения анализа NPE (Null Pointer Exception);
    rawtypes - игнорировать предупреждения, относящиеся к использованию нестандартных типов в шаблонах;
    restriction - игнорировать использования запрещенных объектов;
    serial - игнорировать отсутствие serialVersionUID для сериализуемых классов;
    static-access - игнорировать некорректный доступ к статическим переменным;
    synthetic-access -игнорировать неоптимизированный доступ к внутренним классам;
    unchecked - игнорировать неподтвержденные операции (неявные преобразования и т.п.);
    unqualified-field-access игнорировать неправомочный доступ к полям;
    unused - игнорировать предупреждения о коде, который не используется.
    */
}
