package tax.bilibili.nineblog.view.service

import org.springframework.stereotype.Service
import java.net.URL
import java.net.URLClassLoader
import java.util.jar.JarEntry
import java.util.jar.JarFile


@Service
class ViewService {

    val clazzList = ArrayList<Class<*>>()

    fun loadViewComponent(): Unit {
//        Thread.currentThread().contextClassLoader
//        var loader = URLClassLoader( arrayOf(URL("file://./theme-test-0.0.1-SNAPSHOT.jar")))
//        var jar = JarFile("./theme-test-0.0.1-SNAPSHOT.jar")
//        var entries = jar.entries()
//        while (entries.hasMoreElements()) {
//            val entry: JarEntry = entries.nextElement()
//            println(entry.name)
//            if (entry.getName().endsWith(".class")) {
//                val className: String = entry.getName().replace(".class", "").replace("/", ".")
//                val clazz: Class<*> = loader.loadClass(className)
//                classes.add(clazz)
//            }
//        }
//        var clazz = loader.loadClass("tax.bilibili.nineblog.themetest.ViewController")
//        val beanDefinitionBuilder: BeanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz)
//        var factory =  AA.s.beanFactory as BeanDefinitionRegistry
//        factory.registerBeanDefinition()
    }
}