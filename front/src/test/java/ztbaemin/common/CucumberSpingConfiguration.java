package ztbaemin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ztbaemin.FrontApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { FrontApplication.class })
public class CucumberSpingConfiguration {}
