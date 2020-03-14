package com.xm.demo.tx;

import javafx.scene.transform.Translate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("com.xm.demo.tx")
@Configuration
public class TxConfig {



}