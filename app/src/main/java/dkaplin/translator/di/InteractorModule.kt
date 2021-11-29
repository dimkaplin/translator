package dkaplin.translator.di

import dagger.Module
import dagger.Provides
import dkaplin.translator.model.data.WordModel
import dkaplin.translator.model.repository.Repository
import dkaplin.translator.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<WordModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<WordModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
