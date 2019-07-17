package com.jpmc

import java.io.IOException
import java.io.InputStream
import java.util.Properties
import java.io.FileInputStream

object PropertyUtils {

  private var props: Properties = new Properties()

  def initProperties(filePath: String): Unit = {
    try {
      val inputStream: InputStream = new FileInputStream(filePath);

      //loading properties object with input stream of property file
      props.load(inputStream)
    } catch {
      case ioe: IOException => ioe.printStackTrace()
      case e: Exception     => e.printStackTrace()
    }
  }

  def getProperty(key: String): String = {
    val value: String = props.getProperty(key)
    if (value == null) return ""
    else return value
  }

  def getProperties(): Properties = {
    props
  }

  def setProperty(key: String, value: String): Unit = {
    props.setProperty(key, value)
  }

}