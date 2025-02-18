package com.github.hbq969.code.common.mybatis;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author : hbq969@gmail.com
 * @description : 动态包路径扫描器扫描注解
 * @createTime : 14:36:31, 2023.03.30, 周四
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(WafMapperScannerRegistrar.class)
public @interface WafMapperScan {

  /**
   * Alias for the {@link #basePackages()} attribute. Allows for more concise annotation declarations e.g.: {@code @EnableMyBatisMapperScanner("org.my.pkg")}
   * instead of {@code
   *
   * @EnableMyBatisMapperScanner(basePackages= "org.my.pkg"})}.
   */
  String[] value() default {};

  /**
   * Base packages to scan for MyBatis interfaces. Note that only interfaces with at least one method will be registered; concrete classes will be ignored.
   */
  String[] basePackages() default {};

  /**
   * Type-safe alternative to {@link #basePackages()} for specifying the packages to scan for annotated components. The package of each class specified will be
   * scanned.
   * <p>Consider creating a special no-op marker class or interface in each package
   * that serves no purpose other than being referenced by this attribute.
   */
  Class<?>[] basePackageClasses() default {};

  /**
   * The {@link BeanNameGenerator} class to be used for naming detected components within the Spring container.
   */
  Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

  /**
   * This property specifies the annotation that the scanner will search for.
   * <p>
   * The scanner will register all interfaces in the base package that also have the specified annotation.
   * <p>
   * Note this can be combined with markerInterface.
   */
  Class<? extends Annotation> annotationClass() default Annotation.class;

  /**
   * This property specifies the parent that the scanner will search for.
   * <p>
   * The scanner will register all interfaces in the base package that also have the specified interface class as a parent.
   * <p>
   * Note this can be combined with annotationClass.
   */
  Class<?> markerInterface() default Class.class;

  /**
   * Specifies which {@code SqlSessionTemplate} to use in the case that there is more than one in the spring context. Usually this is only needed when you have
   * more than one datasource.
   */
  String sqlSessionTemplateRef() default "";

  /**
   * Specifies which {@code SqlSessionFactory} to use in the case that there is more than one in the spring context. Usually this is only needed when you have
   * more than one datasource.
   */
  String sqlSessionFactoryRef() default "";

  /**
   * Specifies a custom MapperFactoryBean to return a mybatis proxy as spring bean.
   */
  Class<? extends MapperFactoryBean> factoryBean() default MapperFactoryBean.class;
}
