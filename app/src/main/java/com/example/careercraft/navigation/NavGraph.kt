package com.example.careercraft.navigation
import com.example.careercraft.ui.onboarding.*
import com.example.careercraft.ui.auth.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.careercraft.ui.dashboard.*
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.careercraft.ui.jobs.*
import com.example.careercraft.ui.client.*
import com.example.careercraft.ui.contracts.*


object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val ROLE_SELECT = "role_select"
    const val EXPERIENCE_LEVEL = "experience_level"
    const val SKILL_ASSESSMENT = "skill_assessment"
    const val CAREER_MATCH = "career_match"
    const val CATEGORY_PICKER = "category_picker"
    const val FREELANCER_HOME = "freelancer_home"
    const val CLIENT_HOME = "client_home"
    const val JOB_FEED = "job_feed"
    const val JOB_DETAIL = "job_detail/{jobId}"
    const val PROPOSAL_FORM = "proposal_form/{jobId}"

    fun jobDetail(jobId: String) = "job_detail/$jobId"
    fun proposalForm(jobId: String) = "proposal_form/$jobId"
    const val MY_PROPOSALS = "my_proposals"
    const val POST_JOB = "post_job"
    const val MY_JOBS = "my_jobs"
    const val JOB_APPLICANTS = "job_applicants/{jobId}"
    fun jobApplicants(jobId: String) = "job_applicants/$jobId"
    const val CONTRACT_DETAIL = "contract_detail/{contractId}"
    const val CHAT_LIST = "chat_list"
    const val CHAT = "chat/{contractId}"

    fun contractDetail(contractId: String) = "contract_detail/$contractId"
    fun chat(contractId: String) = "chat/$contractId"
    const val PORTFOLIO_GRID = "portfolio_grid"
    const val PORTFOLIO_FORM = "portfolio_form"
    const val PROFILE_SETTINGS = "profile_settings"
    const val NOTIFICATIONS = "notifications"
    const val RATING = "rating/{contractId}"
    fun rating(contractId: String) = "rating/$contractId"



}

@Composable
fun PlaceholderScreen(name: String) {
    Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(name)
    }
}




@Composable
fun CareerCraftNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN) { popUpTo(Routes.SPLASH) { inclusive = true } }
                },
                onNavigateToDashboard = { role ->
                    val destination = if (role == "client") Routes.CLIENT_HOME else Routes.FREELANCER_HOME
                    navController.navigate(destination) { popUpTo(Routes.SPLASH) { inclusive = true } }
                }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.SPLASH) { popUpTo(0) { inclusive = true } }
                },
                onNavigateToSignUp = { navController.navigate(Routes.SIGNUP) }
            )
        }
        composable(Routes.SIGNUP) {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(Routes.ROLE_SELECT) { popUpTo(Routes.SPLASH) { inclusive = true } }
                },
                onNavigateToLogin = { navController.popBackStack() }
            )
        }
        composable(Routes.ROLE_SELECT) {
            RoleSelectScreen(
                onFreelancerSelected = { navController.navigate(Routes.EXPERIENCE_LEVEL) },
                onClientProfileCreated = {
                    navController.navigate(Routes.CLIENT_HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                }
            )
        }
        composable(Routes.EXPERIENCE_LEVEL) {
            ExperienceLevelScreen(
                onBeginnerProfileCreated = {
                    navController.navigate(Routes.SKILL_ASSESSMENT) { popUpTo(Routes.SPLASH) { inclusive = true } }
                },
                onExpertProfileCreated = {
                    navController.navigate(Routes.CATEGORY_PICKER) { popUpTo(Routes.SPLASH) { inclusive = true } }
                }
            )
        }
        composable(Routes.SKILL_ASSESSMENT) {
            SkillAssessmentScreen(
                onFinished = { navController.navigate(Routes.CAREER_MATCH) }
            )
        }
        composable(Routes.CAREER_MATCH) {
            CareerMatchResultsScreen(
                onAccept = {
                    navController.navigate(Routes.FREELANCER_HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                },
                onNotSatisfied = { navController.navigate(Routes.CATEGORY_PICKER) }
            )
        }
        composable(Routes.CATEGORY_PICKER) {
            CategoryPickerScreen(
                onCategoriesSaved = {
                    navController.navigate(Routes.FREELANCER_HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                }
            )
        }
        composable(Routes.FREELANCER_HOME) {
            FreelancerHomeScreen(
                onFindJobs = { navController.navigate(Routes.JOB_FEED) },
                onPortfolio = { navController.navigate(Routes.PORTFOLIO_GRID) },
                onMessages = { navController.navigate(Routes.CHAT_LIST) },
                onProposals = { navController.navigate(Routes.MY_PROPOSALS) },
                onSignedOut = {
                    navController.navigate(Routes.LOGIN) { popUpTo(0) { inclusive = true } }
                }
            )
        }
        composable(Routes.CLIENT_HOME) {
            ClientHomeScreen(
                onPostJob = { navController.navigate(Routes.POST_JOB) },
                onMyJobs = { navController.navigate(Routes.MY_JOBS) },
                onMessages = { navController.navigate(Routes.CHAT_LIST) },
                onSignedOut = {
                    navController.navigate(Routes.LOGIN) { popUpTo(0) { inclusive = true } }
                }
            )
        }
        composable(Routes.JOB_FEED) {
            JobFeedScreen(onJobClick = { jobId -> navController.navigate(Routes.jobDetail(jobId)) })
        }
        composable(
            route = Routes.JOB_DETAIL,
            arguments = listOf(navArgument("jobId") { type = NavType.StringType })
        ) { backStackEntry ->
            val jobId = backStackEntry.arguments?.getString("jobId") ?: return@composable
            JobDetailScreen(jobId = jobId, onApply = { navController.navigate(Routes.proposalForm(it)) })
        }
        composable(
            route = Routes.PROPOSAL_FORM,
            arguments = listOf(navArgument("jobId") { type = NavType.StringType })
        ) { backStackEntry ->
            val jobId = backStackEntry.arguments?.getString("jobId") ?: return@composable
            ProposalFormScreen(
                jobId = jobId,
                onSubmitted = {
                    navController.navigate(Routes.FREELANCER_HOME) { popUpTo(Routes.SPLASH) { inclusive = true } }
                }
            )
        }
        composable(Routes.MY_PROPOSALS) {
            MyProposalsScreen(onOpenContract = { navController.navigate(Routes.contractDetail(it)) })
        }
        composable(Routes.POST_JOB) {
            PostJobScreen(
                onPosted = {
                    navController.navigate(Routes.MY_JOBS) { popUpTo(Routes.CLIENT_HOME) }
                }
            )
        }
        composable(Routes.MY_JOBS) {
            MyJobsScreen(onJobClick = { jobId -> navController.navigate(Routes.jobApplicants(jobId)) })
        }
        composable(
            route = Routes.JOB_APPLICANTS,
            arguments = listOf(navArgument("jobId") { type = NavType.StringType })
        ) { backStackEntry ->
            val jobId = backStackEntry.arguments?.getString("jobId") ?: return@composable
            JobApplicantsScreen(
                jobId = jobId,
                onHired = { contractId -> navController.navigate(Routes.contractDetail(contractId)) { popUpTo(Routes.CLIENT_HOME) } }
            )
        }
        composable(
            route = Routes.CONTRACT_DETAIL,
            arguments = listOf(navArgument("contractId") { type = NavType.StringType })
        ) { backStackEntry ->
            val contractId = backStackEntry.arguments?.getString("contractId") ?: return@composable
            ContractDetailScreen(
                contractId = contractId,
                onOpenChat = { navController.navigate(Routes.chat(it)) },
                onBothCompleted = { navController.navigate(Routes.RATING) }
            )
        }
        composable(Routes.CHAT_LIST) { PlaceholderScreen("Chat List") }
        composable(
            route = Routes.CHAT,
            arguments = listOf(navArgument("contractId") { type = NavType.StringType })
        ) { backStackEntry ->
            val contractId = backStackEntry.arguments?.getString("contractId") ?: return@composable
            ChatScreen(contractId = contractId)
        }
        composable(Routes.PORTFOLIO_GRID) { PlaceholderScreen("Portfolio Grid") }
        composable(Routes.PORTFOLIO_FORM) { PlaceholderScreen("Portfolio Form") }
        composable(Routes.PROFILE_SETTINGS) { PlaceholderScreen("Profile Settings") }
        composable(Routes.NOTIFICATIONS) { PlaceholderScreen("Notifications") }
        composable(
            route = Routes.RATING,
            arguments = listOf(navArgument("contractId") { type = NavType.StringType })
        ) { backStackEntry ->
            val contractId = backStackEntry.arguments?.getString("contractId") ?: return@composable
            RatingScreen(
                contractId = contractId,
                onDone = { navController.navigate(Routes.SPLASH) { popUpTo(0) { inclusive = true } } }
            )
        }



    }
}


