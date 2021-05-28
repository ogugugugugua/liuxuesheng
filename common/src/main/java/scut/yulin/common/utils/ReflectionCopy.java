package scut.yulin.common.utils;

import java.lang.reflect.Method;

/**
 * @Date 2021/5/28
 * @Author xieyulin
 * @Description 利用反射进行类型赋值
 **/
public class ReflectionCopy {

  /**
   * String类型setter，带判空，用于属性更新
   *
   * @param obj 目标对象
   * @param att 类成员名字
   * @param value 类成员属性
   */
  public static void stringSetterForUpdate(Object obj, String att, Object value) {
    if (Inspections.isNotBlank((String) value)) {
      stringSetter(obj, att, value);
    }
  }

  /**
   * String类型setter
   *
   * @param obj 目标对象
   * @param att 类成员名字
   * @param value 类成员属性
   */
  public static void stringSetter(Object obj, String att, Object value) {
    setter(obj, att, value, String.class);
  }

  public static void setter(Object obj, String att, Object value, Class<?> type) {
    try {
      Method met = obj.getClass().
          getMethod("set" + initStr(att), type);
      met.invoke(obj, value);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void getter(Object obj, String att) {
    try {
      Method met = obj.getClass().getMethod("get" + initStr(att));
      System.out.println(met.invoke(obj));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String initStr(String old) {  // 将单词的首字母大写
    return old.substring(0, 1).toUpperCase() + old.substring(1);
  }
}
