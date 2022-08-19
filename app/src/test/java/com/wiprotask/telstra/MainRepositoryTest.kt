package com.wiprotask.telstra

import com.wiprotask.telstra.repository.MainRepository
import com.wiprotask.telstra.util.NetworkState
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class MainRepositoryTest {

    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var apiService: RetrofitService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainRepository = MainRepository(apiService)
    }

    @Test
    fun `get all fact test`() {
         val response = mainRepository.getAllFact()
            assertEquals(listOf<Fact>(),  NetworkState.Success(response).data)
    }

}