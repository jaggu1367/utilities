package com.jpmc

import java.util.Properties
import java.io.FileWriter

object OffsetFileHandlerApp {
  
  
  def main(args: Array[String]): Unit = {
    val offsetFilePath = "D:/Jagadeesh/parT/scalaWS/OffsetRecordHandler/resources/application.properties"
    println(offsetFilePath)
    PropertyUtils.initProperties(offsetFilePath)
    var props = PropertyUtils.getProperties()
   
    println("Printing keys")
    printKeys(props)    
    println("Printing the file as is")
    printProperties(props)
    
    // set an existing property to file     
    props.setProperty("7", "7007")     
    props.setProperty("8", "8008")
    
    dumpPropertiesToFile(props, offsetFilePath)
    
    props = PropertyUtils.getProperties()
    println("Printing keys")
    printKeys(props)    
    println("Printing the file as is")
    printProperties(props)
  }
  
  def dumpPropertiesToFile(props:Properties, filepath:String){
    val writer:FileWriter = new FileWriter(filepath, false)
    props.store(writer, null)
    writer.close()
  }
  
  def printKeys(props:Properties):Unit={
    val keys = props.stringPropertyNames()
    keys.forEach(println)
  }
  
  
  def printProperties(props:Properties):Unit={
    val keys = props.stringPropertyNames()
    keys.forEach(key=>{
      println(s"$key=${PropertyUtils.getProperty(key)}")  
    })
  }
  
  
  
}