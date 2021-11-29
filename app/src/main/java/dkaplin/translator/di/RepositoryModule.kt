package dkaplin.translator.di

import dagger.Module
import dagger.Provides
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.datasource.DataSource
import dkaplin.translator.model.datasource.RetrofitImplementation
import dkaplin.translator.model.datasource.RoomDataBaseImplementation
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.model.repository.RepositoryImplementation
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<WordModel>>): Repository<List<WordModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<WordModel>>): Repository<List<WordModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<WordModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<WordModel>> = RoomDataBaseImplementation()
}
