package fis.criminal.dao.mem;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.model.CriminalCase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//@Slf4j
public class CriminalCaseDAOTest {
        public static Logger LOG = LoggerFactory.getLogger(fis.criminal.dao.mem.CriminalCaseDAOTest.class);
        public static ICriminalCaseDAO iCriminalCaseDAO = new CriminalCaseDAO();
        @BeforeAll
        public static void initTest(){
            LOG.info("initTest");
        }

        @BeforeEach
        public void initDataEachTest(){
            LOG.info("initDataEachTest");

            MemoryDataSource.CRIMINAL_CASES.clear();

            CriminalCase criminalCase1 =  new CriminalCase();
            criminalCase1.setId(1);
            CriminalCase criminalCase2 =  new CriminalCase();
            criminalCase2.setId(2);
            CriminalCase criminalCase3 =  new CriminalCase();
            criminalCase3.setId(3);

            MemoryDataSource.CRIMINAL_CASES.add(criminalCase1);
            MemoryDataSource.CRIMINAL_CASES.add(criminalCase2);
            MemoryDataSource.CRIMINAL_CASES.add(criminalCase3);
        }


        @Nested
        class save{
            @Test
            void save_CriminalCaseNotExist() {
                //A1: Arrange
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(4);
                criminalCase.setNumber("0004");
                //A2: Action
                ICriminalCaseDAO iCriminalCaseDAO = new CriminalCaseDAO();
                iCriminalCaseDAO.save(criminalCase);

                //A3: Assert | ...
                assertEquals(4, MemoryDataSource.CRIMINAL_CASES.size());
            }
            //
            @ParameterizedTest
            @ValueSource(ints = {4,5,6})
            void criminalWithId(int id){
                //A1
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(id);

                //A2
                iCriminalCaseDAO.save(criminalCase);

                //A3
                assertEquals(4, MemoryDataSource.CRIMINAL_CASES.size());
            }



            @Test
            void save_CriminalCaseExist() {
                //A1
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(1);
                criminalCase.setNumber("0001");

                //A2

                iCriminalCaseDAO.save(criminalCase);

                //A3
                assertEquals(4, MemoryDataSource.CRIMINAL_CASES.size());
            }
        }




        @Test
        void get() {
            LOG.info("test get");
        }

        @Test
        void getAll() {
            List<CriminalCase> actual = MemoryDataSource.CRIMINAL_CASES;
            CriminalCase criminalCase1 =  new CriminalCase();
            criminalCase1.setId(1);
            CriminalCase criminalCase2 =  new CriminalCase();
            criminalCase2.setId(2);
            CriminalCase criminalCase3 =  new CriminalCase();
            criminalCase3.setId(3);

            assertThat(actual, hasSize(3));
            assertThat(actual, instanceOf(List.class));
            assertThat(actual,hasItem(criminalCase1));
            assertThat(actual,hasItem(criminalCase2));
            assertThat(actual,hasItem(criminalCase3));
            assertThat(actual,contains(criminalCase1,criminalCase2,criminalCase3));


            LOG.info("test getAll");
        }

        @Test
        void update() {
            //given
            CriminalCase criminalCase1 =  new CriminalCase();
            criminalCase1.setId(1);
            //when  khi mk update
            iCriminalCaseDAO.update(criminalCase1);
            //then
            //Asser

            LOG.info("test update");
        }

        @Test
        void delete() {
            //when
            boolean result = iCriminalCaseDAO.delete(1);
            assertFalse(result);

        }

        @AfterEach
        public void clearDataEachTest() {
            LOG.info("clearDataEachTest");
        }

        @AfterAll
        public static void clearTest(){
            LOG.info("clearTest");
        }
}