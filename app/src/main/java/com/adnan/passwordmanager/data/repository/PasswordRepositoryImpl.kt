package com.adnan.passwordmanager.data.repository

import com.adnan.passwordmanager.data.encryption.CryptoManager
import com.adnan.passwordmanager.data.local.PasswordDao
import com.adnan.passwordmanager.data.local.PasswordEntity
import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.domain.repository.PasswordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Adnan.
 */
class PasswordRepositoryImpl(
    private val dao: PasswordDao,
    private val crypto: CryptoManager
) : PasswordRepository {

    override fun getAll(): Flow<List<PasswordItem>> =
        dao.getAll().map { list ->
            list.map {
                PasswordItem(
                    id = it.id,
                    accountName = it.accountName,
                    username = it.username,
                    password = crypto.decrypt(it.encryptedPassword)
                )
            }
        }

    override suspend fun add(item: PasswordItem) {
        dao.add(
            PasswordEntity(
                accountName = item.accountName,
                username = item.username,
                encryptedPassword = crypto.encrypt(item.password)
            )
        )
    }

    override suspend fun update(item: PasswordItem) {
        dao.update(
            PasswordEntity(
                id = item.id,
                accountName = item.accountName,
                username = item.username,
                encryptedPassword = crypto.encrypt(item.password)
            )
        )
    }

    override suspend fun delete(item: PasswordItem) {
        dao.delete(
            PasswordEntity(
                id = item.id,
                accountName = item.accountName,
                username = item.username,
                encryptedPassword = crypto.encrypt(item.password)
            )
        )
    }
}