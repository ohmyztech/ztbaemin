package ztbaemin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ztbaemin.CustomerCenterApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerCenterApplication.class })
public class CucumberSpingConfiguration {}
